package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView

class OwnerHomepageActivity : AppCompatActivity() {
    private var username: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.ownerhomeactivity)

            // Retrieve data from intent
            username = intent.getStringExtra("username")
            if (username == null) {
                android.util.Log.w("OwnerHomepage", "No username provided in intent")
            }

        val profileButton: ImageButton = findViewById(R.id.profileButton)
        val notificationButton: ImageButton = findViewById(R.id.notificationButton)
        val postPropertyButton: androidx.cardview.widget.CardView = findViewById(R.id.postPropertyButton)
        val myListingsButton: androidx.cardview.widget.CardView = findViewById(R.id.myListingsButton)
        val landCalculatorButton: androidx.cardview.widget.CardView = findViewById(R.id.landCalculatorButton)
        val weatherInfoButton: androidx.cardview.widget.CardView = findViewById(R.id.weatherInfoButton)
        val postLandButton: LinearLayout = findViewById(R.id.postLandButton)
        val navHome: LinearLayout = findViewById(R.id.nav_home)
        val navSmartlands: LinearLayout = findViewById(R.id.nav_smartlands)
        val navListings: LinearLayout = findViewById(R.id.nav_listings)

        profileButton.setOnClickListener {
            val intent = Intent(this, OwnerProfileActivity::class.java)
            startActivity(intent)
        }

        notificationButton.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        postPropertyButton.setOnClickListener {
            val intent = Intent(this, BasicInformationActivity::class.java)
            startActivity(intent)
        }

        myListingsButton.setOnClickListener {
            val intent = Intent(this, MyListingsActivity::class.java)
            startActivity(intent)
        }

        landCalculatorButton.setOnClickListener {
            val intent = Intent(this, LandCalculatorActivity::class.java)
            startActivity(intent)
        }

        weatherInfoButton.setOnClickListener {
            val intent = Intent(this, WeatherReportActivity::class.java)
            startActivity(intent)
        }

        postLandButton.setOnClickListener {
            val intent = Intent(this, BasicInformationActivity::class.java)
            startActivity(intent)
        }

        navHome.setOnClickListener {
            // Already on home, no action needed
        }

        navSmartlands.setOnClickListener {
            val intent = Intent(this, UserSmartLandsActivity::class.java)
            startActivity(intent)
        }

        navListings.setOnClickListener {
            val intent = Intent(this, ActivityLandListings::class.java)
            startActivity(intent)
        }
    } catch (e: Exception) {
            android.util.Log.e("OwnerHomepage", "Error in onCreate: ${e.message}")
            // Show error dialog or toast
            android.widget.Toast.makeText(this, "Error initializing the app. Please try again.", android.widget.Toast.LENGTH_LONG).show()
            // Restart the app gracefully
            val intent = Intent(this, WelcomeActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        try {
            // Refresh any necessary data here
        } catch (e: Exception) {
            android.util.Log.e("OwnerHomepage", "Error in onResume: ${e.message}")
        }
    }

    override fun onPause() {
        try {
            super.onPause()
            // Clean up any resources if needed
        } catch (e: Exception) {
            android.util.Log.e("OwnerHomepage", "Error in onPause: ${e.message}")
        }
    }
}