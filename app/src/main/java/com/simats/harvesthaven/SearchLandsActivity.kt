package com.simats.harvesthaven

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.RangeSlider
import com.google.android.material.textfield.TextInputLayout

class SearchLandsActivity : AppCompatActivity() {
    private lateinit var landTypeSpinner: Spinner
    private lateinit var cropTypeSpinner: Spinner
    private lateinit var locationSearchInput: EditText
    private lateinit var areaRangeSlider: RangeSlider
    private lateinit var applyFiltersButton: android.widget.Button
    private lateinit var searchResultsRecyclerView: RecyclerView
    private lateinit var radiusInputLayout: TextInputLayout
    private lateinit var radiusInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_lands)

        initializeViews()
        setupSpinners()
        setupRangeSlider()
        setupSearchButton()
    }

    private fun initializeViews() {
        landTypeSpinner = findViewById(R.id.landTypeSpinner)
        cropTypeSpinner = findViewById(R.id.cropTypeSpinner)
        locationSearchInput = findViewById(R.id.locationSearchInput)
        areaRangeSlider = findViewById(R.id.areaRangeSlider)
        applyFiltersButton = findViewById(R.id.applyFiltersButton)
        searchResultsRecyclerView = findViewById(R.id.searchResultsRecyclerView)
        radiusInputLayout = findViewById(R.id.radiusInputLayout)
        radiusInput = findViewById(R.id.radiusInput)

        // Setup RecyclerView
        searchResultsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun setupSpinners() {
        // Setup Land Type Spinner
        val landTypes = arrayOf("All Types", "Farmland", "Paddy Field", "Orchard", "Plantation")
        ArrayAdapter(this, android.R.layout.simple_spinner_item, landTypes).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            landTypeSpinner.adapter = this
        }

        // Setup Crop Type Spinner
        val cropTypes = arrayOf("All Crops", "Rice", "Wheat", "Vegetables", "Fruits", "Cotton", "Sugarcane")
        ArrayAdapter(this, android.R.layout.simple_spinner_item, cropTypes).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            cropTypeSpinner.adapter = this
        }
    }

    private fun setupRangeSlider() {
        areaRangeSlider.apply {
            valueFrom = 0.0f
            valueTo = 100.0f
            values = listOf(0.0f, 100.0f)
            stepSize = 1.0f

            addOnChangeListener { slider, _, _ ->
                val values = slider.values
                updateAreaRangeLabel(values[0], values[1])
            }
        }
    }

    private fun updateAreaRangeLabel(start: Float, end: Float) {
        // Update area range label if you have one
        val rangeText = String.format("%.1f - %.1f acres", start, end)
        // You can set this text to a TextView if needed
    }

    private fun setupSearchButton() {
        applyFiltersButton.setOnClickListener { performSearch() }
    }

    private fun performSearch() {
        // Get filter values
        val landType = landTypeSpinner.selectedItem.toString()
        val cropType = cropTypeSpinner.selectedItem.toString()
        val location = locationSearchInput.text.toString()
        val radiusStr = radiusInput.text.toString()
        val areaRange = areaRangeSlider.values

        // Validate inputs
        when {
            location.isEmpty() -> {
                Toast.makeText(this, "Please enter a location", Toast.LENGTH_SHORT).show()
                return
            }
            radiusStr.isEmpty() -> {
                Toast.makeText(this, "Please enter a search radius", Toast.LENGTH_SHORT).show()
                return
            }
        }

        // Create search parameters
        val params = SearchParams(
            landType = if (landType == "All Types") null else landType,
            cropType = if (cropType == "All Crops") null else cropType,
            location = location,
            radius = radiusStr.toInt(),
            minArea = areaRange[0],
            maxArea = areaRange[1]
        )

        // Perform the search
        searchLands(params)
    }

    private fun searchLands(params: SearchParams) {
        // TODO: Implement API call to search lands
        // This would typically involve:
        // 1. Making an API request with the search parameters
        // 2. Receiving the results
        // 3. Updating the RecyclerView with the results
        
        val searchMsg = "Searching for ${params.landType ?: "all"} lands with ${params.cropType ?: "all"} crops near ${params.location} within ${params.radius} km"
        Toast.makeText(this, searchMsg, Toast.LENGTH_LONG).show()
    }

    private data class SearchParams(
        val landType: String?,
        val cropType: String?,
        val location: String,
        val radius: Int,
        val minArea: Float,
        val maxArea: Float
    )
}

