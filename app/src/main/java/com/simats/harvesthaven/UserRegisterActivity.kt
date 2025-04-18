package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import retrofit2.Response


class UserRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_register_activity)

        val etName = findViewById<EditText>(R.id.etName)
        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val tvSwitchToLogin = findViewById<TextView>(R.id.tvSwitchToLogin)

        btnRegister.setOnClickListener {
            val name = etName.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val phone = etPhone.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (name.isEmpty() || username.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            } else {
                registerUser(name, username, email, phone, password)
            }
        }

        tvSwitchToLogin.setOnClickListener {
            val intent = Intent(this, UserLoginAuthActivity::class.java)
            startActivity(intent)
        }
    }
    private fun registerUser(name: String, username: String, email: String, phone: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = safeApiCall { RetrofitClient.apiService.register(RegisterRequest(name, username, email, phone, password)) }
            withContext(Dispatchers.Main) {
                if (response?.isSuccessful == true) {
                    val message = response.body()?.message ?: "Unknown error"
                    Toast.makeText(this@UserRegisterActivity, message, Toast.LENGTH_LONG).show()
                    if (message == "User registered successfully") {
                        finish()
                    }
                } else {
                    val errorMessage = response?.errorBody()?.string() ?: "Unknown error"
                    Toast.makeText(this@UserRegisterActivity, "Registration failed: $errorMessage", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    private suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): Response<T>? {
        return try {
            apiCall()
        } catch (e: Exception) {
            Log.e("SafeApiCall", "API call failed: ${e.message}")
            null
        }
    }
}
