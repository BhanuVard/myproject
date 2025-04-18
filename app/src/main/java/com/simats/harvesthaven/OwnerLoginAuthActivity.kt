package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.simats.harvesthaven.api.ApiService
import com.simats.harvesthaven.api.LoginRequest
import com.simats.harvesthaven.api.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class OwnerLoginAuthActivity : AppCompatActivity() {

    override fun onDestroy() {
        try {
            // Clean up any resources
            super.onDestroy()
        } catch (e: Exception) {
            android.util.Log.e("OwnerLoginAuth", "Error in onDestroy: ${e.message}")
        }
    }

    override fun onPause() {
        try {
            // Clean up any UI-related resources
            super.onPause()
        } catch (e: Exception) {
            android.util.Log.e("OwnerLoginAuth", "Error in onPause: ${e.message}")
        }
    }


    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvRegister: TextView
    private lateinit var btnPhoneLogin: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        try {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.owner_login_acitvity)

            etUsername = findViewById(R.id.etUsername)
            etPassword = findViewById(R.id.etPassword)
            btnLogin = findViewById(R.id.btnLogin)
            tvRegister = findViewById(R.id.tvRegister)
            btnPhoneLogin = findViewById(R.id.btnPhoneLogin)

            btnLogin.setOnClickListener {
                val username = etUsername.text.toString().trim()
                val password = etPassword.text.toString().trim()

                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT).show()
                } else {
                    loginUser(username, password)
                }
            }

            tvRegister.setOnClickListener {
                val intent = Intent(this, OwnerRegisterActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }

            btnPhoneLogin.setOnClickListener {
                val intent = Intent(this, MobileActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        } catch (e: Exception) {
            android.util.Log.e("OwnerLoginAuth", "Error in onCreate: ${e.message}")
            Toast.makeText(this, "Error initializing the app. Please try again.", Toast.LENGTH_LONG).show()
            finish()
        }
    }

    private fun loginUser(username: String, password: String) {
        // Disable login button to prevent multiple attempts
        btnLogin.isEnabled = false

        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            try {
                val response = RetrofitClient.apiService.ownerLogin(LoginRequest(username, password))
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful && response.body()?.token != null) {
                        try {
                            // Store token or other necessary data here if needed
                            val token = response.body()?.token

                            // Create intent and add necessary extras
                            val intent = Intent(this@OwnerLoginAuthActivity, OwnerHomepageActivity::class.java).apply {
                                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                putExtra("username", username)
                                // Add any other necessary data
                            }

                            // Show success message
                            Toast.makeText(this@OwnerLoginAuthActivity, "Welcome back, $username!", Toast.LENGTH_SHORT).show()

                            // Start the new activity
                            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                            finish()
                        } catch (e: Exception) {
                            android.util.Log.e("LoginError", "Navigation error: ${e.message}")
                            Toast.makeText(this@OwnerLoginAuthActivity, "Error during login process. Please try again.", Toast.LENGTH_LONG).show()
                        }
                    } else {
                        Toast.makeText(this@OwnerLoginAuthActivity, "Invalid credentials. Please check your username and password.", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    val errorMessage = when {
                        e.message?.contains("Failed to connect") == true -> "Unable to connect to server. Please check your internet connection and try again."
                        e.message?.contains("timeout") == true -> "Connection timed out. Please try again."
                        e.message?.contains("Bad Gateway") == true -> "Server is currently unavailable. Please try again later."
                        e.message?.contains("Unauthorized") == true -> "Invalid credentials. Please check your username and password."
                        else -> "Login failed: An unexpected error occurred. Please try again."
                    }
                    android.util.Log.e("LoginError", "Login failed: ${e.message}")
                    Toast.makeText(this@OwnerLoginAuthActivity, errorMessage, Toast.LENGTH_LONG).show()
                }
            } finally {
                withContext(Dispatchers.Main) {
                    // Re-enable login button
                    btnLogin.isEnabled = true
                }
            }
        }
    }
}