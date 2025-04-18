package com.simats.harvesthaven

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.simats.harvesthaven.api.RetrofitClient
import com.simats.harvesthaven.models.LandPost
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LandDetailActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var contentLayout: ScrollView
    private lateinit var errorLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_detail)

        setupViews()
        val landId = intent.getStringExtra("land_id")
        if (landId != null) {
            loadLandDetails(landId)
        } else {
            showError("Invalid land ID")
        }
    }

    private fun setupViews() {
        progressBar = findViewById(R.id.progressBar)
        contentLayout = findViewById(R.id.contentLayout)
        errorLayout = findViewById(R.id.errorLayout)

        findViewById<Button>(R.id.btnRetry).setOnClickListener {
            val landId = intent.getStringExtra("land_id")
            if (landId != null) {
                loadLandDetails(landId)
            }
        }
    }

    private fun loadLandDetails(landId: String) {
        showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.landService.getLandById(landId)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful && response.body() != null) {
                        displayLandDetails(response.body()!!)
                    } else {
                        showError("Failed to load land details")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showError("Error: ${e.message}")
                }
            }
        }
    }

    private fun displayLandDetails(land: LandPost) {
        hideLoading()
        hideError()

        // Set title and basic info
        findViewById<TextView>(R.id.tvLandTitle).text = land.title
        findViewById<TextView>(R.id.tvLocation).text = "${land.location.city}, ${land.location.state}"
        findViewById<TextView>(R.id.tvArea).text = "${land.area} ${land.areaUnit}"
        findViewById<TextView>(R.id.tvPrice).text = "₹${land.price}"
        findViewById<TextView>(R.id.tvDescription).text = land.description

        // Set owner details
        findViewById<TextView>(R.id.tvOwnerName).text = land.owner
        findViewById<TextView>(R.id.tvOwnerContact).text = land.owner // Note: Contact info might need to be fetched separately

        // Set status with appropriate color
        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        tvStatus.text = land.status
        tvStatus.setTextColor(ContextCompat.getColor(this,
            if (land.isAvailable) android.R.color.holo_green_dark
            else android.R.color.holo_red_dark
        ))

        // Set land features and irrigation status
        val chipGroupFeatures = findViewById<ChipGroup>(R.id.chipGroupFeatures)
        chipGroupFeatures.removeAllViews()
        val features = mutableListOf<String>()
        if (land.irrigation) features.add("Irrigation Available")
        features.add("Soil Type: ${land.soilType}")
        land.waterSource?.forEach { source -> features.add("Water Source: $source") }
        features.forEach { feature ->
            val chip = Chip(this)
            chip.text = feature
            chipGroupFeatures.addView(chip)
        }

        // Set soil type
        findViewById<TextView>(R.id.tvSoilType).text = land.soilType
        findViewById<TextView>(R.id.tvWaterSource).text = land.waterSource?.joinToString(", ") ?: "Not specified"

        // Set crop types
        val chipGroupCrops = findViewById<ChipGroup>(R.id.chipGroupCrops)
        chipGroupCrops.removeAllViews()
        land.cropsCultivated?.forEach { crop ->
            val chip = Chip(this)
            chip.text = crop
            chipGroupCrops.addView(chip)
        }

        // Setup contact button
        findViewById<Button>(R.id.btnContact).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = Uri.parse("tel:${land.ownerContact}")
            }
            startActivity(intent)
        }

        contentLayout.visibility = View.VISIBLE
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
        contentLayout.visibility = View.GONE
        errorLayout.visibility = View.GONE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    private fun showError(message: String) {
        errorLayout.visibility = View.VISIBLE
        contentLayout.visibility = View.GONE
        progressBar.visibility = View.GONE
        findViewById<TextView>(R.id.tvError).text = message
    }

    private fun hideError() {
        errorLayout.visibility = View.GONE
    }
}