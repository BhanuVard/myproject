package com.simats.harvesthaven
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.simats.harvesthaven.models.YearlyProfit

class AddLandHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_land_history)

        val previousUse = intent.getStringExtra("previousUse") ?: ""
        val amenities = intent.getStringArrayListExtra("amenities") ?: arrayListOf()
        val restrictions = intent.getStringArrayListExtra("restrictions") ?: arrayListOf()

        val nextButton = findViewById<Button>(R.id.nextButton)

        nextButton.setOnClickListener {
            val yearlyProfits = mutableListOf<YearlyProfit>()

            // Collect data for each year
            for (year in 1..4) {
                val crops = findViewById<EditText>(resources.getIdentifier("year${year}CropsInput", "id", packageName))
                    .text.toString().split(",").map { it.trim() }
                val acres = findViewById<EditText>(resources.getIdentifier("year${year}AcresInput", "id", packageName))
                    .text.toString().toDoubleOrNull() ?: 0.0
                val profit = findViewById<EditText>(resources.getIdentifier("year${year}ProfitInput", "id", packageName))
                    .text.toString().toDoubleOrNull() ?: 0.0

                if (crops.isNotEmpty() && acres > 0 && profit > 0) {
                    yearlyProfits.add(YearlyProfit(
                        year = year,
                        amount = profit,
                        crops = crops,
                        area = acres
                    ))
                }
            }

            if (yearlyProfits.isEmpty()) {
                Toast.makeText(this, "Please enter at least one year's profit details", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, UploadLandPhotosActivity::class.java).apply {
                putExtra("previousUse", previousUse)
                putStringArrayListExtra("amenities", ArrayList(amenities))
                putStringArrayListExtra("restrictions", ArrayList(restrictions))
                // We'll need to create a Parcelable for YearlyProfit to pass it through intent
                // For now, we'll store it in a singleton data holder
                LandData.getInstance().yearlyProfits = yearlyProfits
            }
            startActivity(intent)
        }
    }
}
