package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.simats.harvesthaven.api.RegisterRequest
import com.simats.harvesthaven.api.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.IOException

class OwnerRegisterActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etUsername: EditText
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button
    private lateinit var tvSwitchToLogin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.owner_register_activity)

        etName = findViewById(R.id.etName)
        etUsername = findViewById(R.id.etUsername)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        btnRegister = findViewById(R.id.btnRegister)
        tvSwitchToLogin = findViewById(R.id.tvSwitchToLogin)

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (name.isEmpty() || username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            } else {
                registerOwner(name, username, email, phone, password)
            }
        }

        tvSwitchToLogin.setOnClickListener {
            val intent = Intent(this, UserLoginAuthActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun registerOwner(name: String, username: String, email: String, phone: String, password: String) {
        btnRegister.isEnabled = false
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitClient.apiService.registerOwner(RegisterRequest(name, username, email, phone, password))
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful && response.body()?.message == "User Registered Successfully") {
                        Toast.makeText(this@OwnerRegisterActivity, "Owner Registered Successfully", Toast.LENGTH_LONG).show()
                        finish()
                    } else {
                        val errorBody = response.errorBody()?.string() ?: "Unknown error occurred"
                        Toast.makeText(this@OwnerRegisterActivity, "Registration failed: $errorBody", Toast.LENGTH_LONG).show()
                    }
                }
            } catch (e: IOException) {
                withContext(Dispatchers.Main) {
                    val errorMessage = when {
                        e.message?.contains("Bad Gateway") == true -> "Server is currently unavailable. Please try again later."
                        e.message?.contains("Bad Request") == true -> "Invalid registration data. Please check your inputs."
                        e.message?.contains("Unauthorized") == true -> "Authentication failed. Please try again."
                        e.message?.contains("Not Found") == true -> "Registration service is not available."
                        e.message?.contains("Internal Server Error") == true -> "Server error occurred. Please try again later."
                        else -> "Network error: ${e.message}"
                    }
                    Toast.makeText(this@OwnerRegisterActivity, errorMessage, Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@OwnerRegisterActivity, "An unexpected error occurred: ${e.message}", Toast.LENGTH_LONG).show()
                }
            } finally {
                withContext(Dispatchers.Main) {
                    btnRegister.isEnabled = true
                }
            }
        }
    }
}