package com.simats.harvesthaven

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserSmartLandsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_smart_land_listings)

        val landPhoto = findViewById<ImageView>(R.id.landPhoto)
        val landTitle = findViewById<TextView>(R.id.landTitle)
        val landLocation = findViewById<TextView>(R.id.landLocation)
        val landSize = findViewById<TextView>(R.id.landSize)
        val landPrice = findViewById<TextView>(R.id.landPrice)
        val landOneB = findViewById<TextView>(R.id.landOneB)
        val landPassbook = findViewById<TextView>(R.id.landPassbook)
        val landAdangal = findViewById<TextView>(R.id.landAdangal)
        val landHealthCard = findViewById<TextView>(R.id.landHealthCard)

        // Set the land details dynamically
        landPhoto.setImageResource(R.drawable.img_9) // Ensure img_9.png exists in res/drawable
        landTitle.text = "Fertile Agricultural Land"
        landLocation.text = "Karnataka, India"
        landSize.text = "5 acres"
        landPrice.text = "₹50,000/acre/year"

        // Set document availability
        val isOneBAvailable = true
        val isPassbookAvailable = true
        val isAdangalAvailable = true
        val isHealthCardAvailable = true

        landOneB.text = if (isOneBAvailable) "One-B: Available" else "One-B: Not Available"
        landPassbook.text = if (isPassbookAvailable) "Passbook: Available" else "Passbook: Not Available"
        landAdangal.text = if (isAdangalAvailable) "Adangal: Available" else "Adangal: Not Available"
        landHealthCard.text = if (isHealthCardAvailable) "Health Card: Available" else "Health Card: Not Available"
    }
}