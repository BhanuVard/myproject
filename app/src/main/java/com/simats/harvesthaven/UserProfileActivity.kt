package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userprofile_activity)

        val btnClose = findViewById<ImageView>(R.id.btnClose)
        val btnEdit = findViewById<TextView>(R.id.btnEdit)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnClose.setOnClickListener {
            finish()
        }

        btnEdit.setOnClickListener {
            Toast.makeText(this, "Edit Profile", Toast.LENGTH_SHORT).show()
            // Navigate to EditProfileActivity
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }
    }
}