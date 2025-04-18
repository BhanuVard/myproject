package com.simats.harvesthaven

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.LinearLayout
import android.widget.TextView

class WeatherReportActivity : AppCompatActivity() {
    data class WeatherInfo(
        val day: String,
        val condition: String,
        val date: String,
        val time: String,
        val temperature: String,
        val humidity: String,
        val windSpeed: String,
        val precipitation: String
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_report)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val weatherContainer: LinearLayout = findViewById(R.id.weatherContainer)

        // Example weather data for 7 days with enhanced information
        val weatherData = listOf(
            WeatherInfo("Thursday", "Sunny", "2025-03-27", "12:00 PM", "28°C", "60%", "10 km/h", "0%"),
            WeatherInfo("Friday", "Cloudy", "2025-03-28", "01:00 PM", "25°C", "65%", "15 km/h", "30%"),
            WeatherInfo("Saturday", "Rainy", "2025-03-29", "02:00 PM", "22°C", "70%", "20 km/h", "80%"),
            WeatherInfo("Sunday", "Sunny", "2025-03-30", "12:00 PM", "27°C", "55%", "12 km/h", "5%"),
            WeatherInfo("Monday", "Windy", "2025-03-31", "03:00 PM", "24°C", "50%", "25 km/h", "20%"),
            WeatherInfo("Tuesday", "Sunny", "2025-04-01", "12:00 PM", "29°C", "60%", "8 km/h", "0%"),
            WeatherInfo("Wednesday", "Rainy", "2025-04-02", "04:00 PM", "23°C", "75%", "18 km/h", "75%")
        )

        // Dynamically add weather data to the container
        for (weather in weatherData) {
            val cardView = androidx.cardview.widget.CardView(this).apply {
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 0, 0, 24)
                }
                radius = resources.getDimension(R.dimen.cardview_default_radius)
                elevation = resources.getDimension(R.dimen.cardview_default_elevation)
            }

            val mainLayout = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                setPadding(32, 32, 32, 32)
            }

            // Header layout with day and temperature
            val headerLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
            }

            val dayTextView = TextView(this).apply {
                text = "${weather.day}"
                textSize = 18f
                setTextColor(resources.getColor(R.color.black))
                setTypeface(null, android.graphics.Typeface.BOLD)
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f
                )
            }

            val temperatureTextView = TextView(this).apply {
                text = weather.temperature
                textSize = 24f
                setTextColor(resources.getColor(R.color.black))
            }

            headerLayout.addView(dayTextView)
            headerLayout.addView(temperatureTextView)

            val conditionTextView = TextView(this).apply {
                text = weather.condition
                textSize = 16f
                setTextColor(resources.getColor(R.color.gray))
                setPadding(0, 8, 0, 0)
            }

            // Details layout
            val detailsLayout = LinearLayout(this).apply {
                orientation = LinearLayout.HORIZONTAL
                setPadding(0, 16, 0, 0)
            }

            val leftColumn = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f
                )
            }

            val rightColumn = LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                layoutParams = LinearLayout.LayoutParams(
                    0,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    1.0f
                )
            }

            // Left column content
            leftColumn.addView(TextView(this).apply {
                text = "Date: ${weather.date}"
                textSize = 14f
                setTextColor(resources.getColor(R.color.gray))
            })

            leftColumn.addView(TextView(this).apply {
                text = "Time: ${weather.time}"
                textSize = 14f
                setTextColor(resources.getColor(R.color.gray))
                setPadding(0, 8, 0, 0)
            })

            // Right column content
            rightColumn.addView(TextView(this).apply {
                text = "Humidity: ${weather.humidity}"
                textSize = 14f
                setTextColor(resources.getColor(R.color.gray))
            })

            rightColumn.addView(TextView(this).apply {
                text = "Wind: ${weather.windSpeed}"
                textSize = 14f
                setTextColor(resources.getColor(R.color.gray))
                setPadding(0, 8, 0, 0)
            })

            rightColumn.addView(TextView(this).apply {
                text = "Precipitation: ${weather.precipitation}"
                textSize = 14f
                setTextColor(resources.getColor(R.color.gray))
                setPadding(0, 8, 0, 0)
            })

            detailsLayout.addView(leftColumn)
            detailsLayout.addView(rightColumn)

            // Add all views to main layout
            mainLayout.addView(headerLayout)
            mainLayout.addView(conditionTextView)
            mainLayout.addView(detailsLayout)

            // Add main layout to card
            cardView.addView(mainLayout)

            // Add card to container
            weatherContainer.addView(cardView)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}