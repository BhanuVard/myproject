package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.simats.harvesthaven.R

class UserHomeActivity : AppCompatActivity() {

    private lateinit var userName: TextView
    private lateinit var searchBar: EditText
    private lateinit var notificationIcon: ImageView
    private lateinit var homeButton: LinearLayout
    private lateinit var searchButton: LinearLayout
    private lateinit var smartLandsButton: LinearLayout
    private lateinit var wishlistButton: LinearLayout
    private lateinit var listingsButton: LinearLayout
    private lateinit var smartAnalysisCard: androidx.cardview.widget.CardView
    private lateinit var landCalculatorCard: androidx.cardview.widget.CardView
    private lateinit var mapFragment: MapFragment
    private lateinit var featuredLandBox: androidx.cardview.widget.CardView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userhomeactivity) // Ensure this layout file exists

        // Initialize views
        userName = findViewById(R.id.userName)
        searchBar = findViewById(R.id.searchBar)
        notificationIcon = findViewById(R.id.notificationIcon)
        smartAnalysisCard = findViewById(R.id.smartAnalysisCard)
        landCalculatorCard = findViewById(R.id.landCalculatorCard)
        featuredLandBox = findViewById(R.id.featuredLandBox)

        // Initialize map fragment
        mapFragment = MapFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.mapContainer, mapFragment)
            .commit()

        // Bottom Navigation Buttons
        homeButton = findViewById(R.id.nav_home)
        searchButton = findViewById(R.id.nav_search)
        smartLandsButton = findViewById(R.id.nav_smartlands)
        wishlistButton = findViewById(R.id.nav_wishlist)
        listingsButton = findViewById(R.id.nav_listings)

        // Set user name dynamically (You can fetch from a database or shared preferences)
        userName.text = "John User"

        // Make userName clickable and redirect to UserProfileActivity
        userName.setOnClickListener {
            val intent = Intent(this, UserProfileActivity::class.java)
            startActivity(intent)
        }

        // Search Bar Functionality
        searchBar.setOnEditorActionListener { _, _, _ ->
            val query = searchBar.text.toString()
            if (query.isNotEmpty()) {
                Toast.makeText(this, "Searching for: $query", Toast.LENGTH_SHORT).show()
            }
            true
        }

        // Card Click Listeners
        smartAnalysisCard.setOnClickListener {
            val intent = Intent(this, SmartAnalysisActivity::class.java)
            startActivity(intent)
        }

        landCalculatorCard.setOnClickListener {
            val intent = Intent(this, LandCalculatorActivity::class.java)
            startActivity(intent)
        }

        notificationIcon.setOnClickListener {
            val intent = Intent(this, NotificationActivity::class.java)
            startActivity(intent)
        }

        // Bottom Navigation Click Listeners
        homeButton.setOnClickListener {
            startActivity(Intent(this, UserHomeActivity::class.java))
            overridePendingTransition(0, 0) // Removes transition animation for smooth navigation
        }

        searchButton.setOnClickListener {
            startActivity(Intent(this, SearchLandsActivity::class.java))
            overridePendingTransition(0, 0)
        }
        smartLandsButton.setOnClickListener {
            val intent = Intent(this, UserSmartLandsActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0) // Removes transition animation for smooth navigation
        }

        wishlistButton.setOnClickListener {
            startActivity(Intent(this, WishlistActivity::class.java))
            overridePendingTransition(0, 0)
        }

        listingsButton.setOnClickListener {
            val intent = Intent(this, MyListingsActivity::class.java)
            startActivity(intent)
        }

        // Featured Land Box Click Listener
        featuredLandBox.setOnClickListener {
            val intent = Intent(this, LandDetailActivity::class.java)
            startActivity(intent)
        }
    }
}