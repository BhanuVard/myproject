package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toast
import com.simats.harvesthaven.R

class MobileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mobile)

        val getOtp = findViewById<TextView>(R.id.tv_get_otp)
        val register = findViewById<TextView>(R.id.tv_register)

        getOtp.setOnClickListener {
            Toast.makeText(this, "OTP Sent", Toast.LENGTH_SHORT).show()
        }

        register.setOnClickListener {
            Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT).show()

            // Navigate to HomePageActivity after registration
            val intent = Intent(this,OwnerHomepageActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
