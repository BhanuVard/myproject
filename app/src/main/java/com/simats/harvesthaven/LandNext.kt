
package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.chip.ChipGroup
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.chip.Chip

import com.simats.harvesthaven.R

class LandNext : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landnext_details)

        val toolbarIcon = findViewById<ImageView?>(R.id.toolbarIcon)
        val redDot = findViewById<View?>(R.id.redDot)
        val soilType = findViewById<EditText?>(R.id.soilType)
        val cropTypes = findViewById<EditText?>(R.id.cropTypes)
        val rent = findViewById<EditText?>(R.id.rent)
        val previousUse = findViewById<EditText?>(R.id.previousUse)
        val amenitiesInput = findViewById<TextInputLayout?>(R.id.amenitiesInput)
        val amenitiesChipGroup = findViewById<ChipGroup?>(R.id.amenitiesChipGroup)
        val restrictionsInput = findViewById<TextInputLayout?>(R.id.restrictionsInput)
        val restrictionsChipGroup = findViewById<ChipGroup?>(R.id.restrictionsChipGroup)
        val nextButton = findViewById<Button?>(R.id.nextButton)

        toolbarIcon?.setOnClickListener {
            redDot?.visibility = View.GONE
        }

        nextButton?.setOnClickListener {
            val soilTypeValue = soilType?.text?.toString()?.trim()
            val cropTypesValue = cropTypes?.text?.toString()?.trim()
            val rentValue = rent?.text?.toString()?.trim()
            val previousUseValue = previousUse?.text?.toString()?.trim()
            val amenities = amenitiesChipGroup?.checkedChipIds?.map { id ->
                (amenitiesChipGroup.findViewById<Chip>(id))?.text?.toString() ?: ""
            } ?: listOf()
            val restrictions = restrictionsChipGroup?.checkedChipIds?.map { id ->
                (restrictionsChipGroup.findViewById<Chip>(id))?.text?.toString() ?: ""
            } ?: listOf()

            if (soilTypeValue.isNullOrEmpty() || cropTypesValue.isNullOrEmpty() || 
                rentValue.isNullOrEmpty() || previousUseValue.isNullOrEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, AddLandHistoryActivity::class.java).apply {
                    putExtra("previousUse", previousUseValue)
                    putStringArrayListExtra("amenities", ArrayList(amenities))
                    putStringArrayListExtra("restrictions", ArrayList(restrictions))
                }
                startActivity(intent)
            }
        }
    }
}