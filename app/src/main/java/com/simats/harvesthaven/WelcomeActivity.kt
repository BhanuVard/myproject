package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.simats.harvesthaven.R

class WelcomeActivity : AppCompatActivity() {

    private lateinit var btnUser: Button
    private lateinit var btnOwner: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_activity)  // Matches your XML file name

        // Initialize buttons
        btnUser = findViewById(R.id.btnUser)
        btnOwner = findViewById(R.id.btnOwner)

        // Navigate to User Login or Registration
        btnUser.setOnClickListener {
            val intent = Intent(this, UserLoginAuthActivity::class.java) // Replace with the actual activity
            startActivity(intent)
        }

        // Navigate to Owner Login or Registration
        btnOwner.setOnClickListener {
            val intent = Intent(this, OwnerLoginAuthActivity::class.java) // Replace with the actual activity
            startActivity(intent)
        }
    }
}
