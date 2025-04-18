package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.simats.harvesthaven.models.LandData

class BasicInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_information) // ✅ Ensure this file exists

        val toolbarIcon: ImageView = findViewById(R.id.toolbarIcon)
        val redDot: View = findViewById(R.id.redDot)
        val landType: EditText? = findViewById(R.id.landType) // ✅ Make sure ID is correct
        val landArea: EditText? = findViewById(R.id.landArea)
        val location: EditText? = findViewById(R.id.location)
        val nextButton: Button = findViewById(R.id.nextButton)

        val landData = LandData.getInstance()

        toolbarIcon.setOnClickListener {
            redDot.visibility = View.GONE
            finish()
        }

        nextButton.setOnClickListener {
            val landTypeValue = landType?.text?.toString()?.trim()
            val landAreaValue = landArea?.text?.toString()?.trim()
            val locationValue = location?.text?.toString()?.trim()

            if (landTypeValue.isNullOrEmpty() || landAreaValue.isNullOrEmpty() || locationValue.isNullOrEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                landData.landType = landTypeValue
                landData.landArea = landAreaValue
                landData.location = locationValue

                val intent = Intent(this, LandNext::class.java)
                startActivity(intent)
            }
        }
    }
}
