package com.simats.harvesthaven

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.simats.harvesthaven.api.LoginRequest
import com.simats.harvesthaven.api.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserLoginAuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_login_acitvity)

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnPhoneLogin = findViewById<ImageView>(R.id.btnPhoneLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        btnLogin.setOnClickListener {
            val email = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                loginUser(email, password)
            }
        }

        btnPhoneLogin.setOnClickListener {
            val intent = Intent(this, UserMobileActivity::class.java)
            startActivity(intent)
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, UserRegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun loginUser(email: String, password: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = safeApiCall { RetrofitClient.apiService.login(LoginRequest(email, password)) }
            withContext(Dispatchers.Main) {
                if (response?.isSuccessful == true && response.body()?.token != null) {
                    Toast.makeText(this@UserLoginAuthActivity, "Login Successful", Toast.LENGTH_LONG).show()
                    // Redirect to UserHomeActivity
                    val intent = Intent(this@UserLoginAuthActivity, UserHomeActivity::class.java)
                    startActivity(intent)
                    finish() // Optional: Call finish() to close the login activity
                } else {
                    val errorMessage = response?.errorBody()?.string() ?: "Invalid username or password"
                    Log.e("LoginUser", "Login failed: $errorMessage")
                    Toast.makeText(this@UserLoginAuthActivity, "Login failed: $errorMessage", Toast.LENGTH_LONG).show()
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