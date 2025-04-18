package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.simats.harvesthaven.adapters.LandAdapter
import com.simats.harvesthaven.api.RetrofitClient
import com.simats.harvesthaven.models.LandPost
import kotlinx.coroutines.*

class LandListingActivity : AppCompatActivity() {
    private lateinit var landRecyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorLayout: LinearLayout
    private lateinit var tvError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_listing)

        landRecyclerView = findViewById(R.id.landRecyclerView)
        progressBar = findViewById(R.id.progressBar)
        errorLayout = findViewById(R.id.errorLayout)
        tvError = findViewById(R.id.tvError)

        landRecyclerView.layoutManager = LinearLayoutManager(this)

        loadLands()
    }

    private fun loadLands() {
        showLoading()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.getAllLands()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful && response.body() != null) {
                        val landList = response.body()!!
                        landRecyclerView.adapter = LandAdapter(landList) { selectedLand ->
                            val intent = Intent(this@LandListingActivity, LandDetailActivity::class.java)
                            intent.putExtra("land_id", selectedLand.id)
                            startActivity(intent)
                        }
                        hideLoading()
                    } else {
                        showError("Failed to load lands")
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    showError("Error: ${e.message}")
                }
            }
        }
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
        landRecyclerView.visibility = View.GONE
        errorLayout.visibility = View.GONE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
        landRecyclerView.visibility = View.VISIBLE
    }

    private fun showError(message: String) {
        progressBar.visibility = View.GONE
        landRecyclerView.visibility = View.GONE
        errorLayout.visibility = View.VISIBLE
        tvError.text = message
    }
}
