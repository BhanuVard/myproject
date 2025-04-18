package com.simats.harvesthaven




import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.editprofileactivity)

        val btnBack = findViewById<ImageView>(R.id.btnBack)
        val btnChangePhoto = findViewById<Button>(R.id.btnChangePhoto)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)

        btnBack.setOnClickListener {
            finish()
        }

        btnChangePhoto.setOnClickListener {
            Toast.makeText(this, "Change Photo Clicked", Toast.LENGTH_SHORT).show()
            // Implement photo change functionality
        }

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmail.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty()) {
                Toast.makeText(this, "Profile Updated", Toast.LENGTH_SHORT).show()
                // Save profile changes
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}