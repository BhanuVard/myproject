package com.simats.harvesthaven

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.simats.harvesthaven.R

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var emailInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var resetButton: Button
    private lateinit var resetSuccessLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgotpassword_activity)

        emailInput = findViewById(R.id.emailInput)
        passwordInput = findViewById(R.id.passwordInput)
        resetButton = findViewById(R.id.resetButton)
        resetSuccessLabel = findViewById(R.id.resetSuccessLabel)

        resetButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if (email.isEmpty()) {
                Toast.makeText(this, "Please enter your email", Toast.LENGTH_SHORT).show()
            } else if (password.isEmpty()) {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show()
            } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "Please enter a valid email", Toast.LENGTH_SHORT).show()
            } else {
                // Simulate a reset success
                resetSuccessLabel.text = "Reset Successful!"
                resetSuccessLabel.visibility = TextView.VISIBLE
                Toast.makeText(this, "Password reset successfully", Toast.LENGTH_SHORT).show()

                // You can add further logic like sending reset details to the backend here.
            }
        }
    }
}
