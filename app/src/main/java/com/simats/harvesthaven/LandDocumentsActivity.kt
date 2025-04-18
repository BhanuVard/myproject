package com.simats.harvesthaven

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LandDocumentsActivity : AppCompatActivity() {

    private val RC_UPLOAD_FILE = 1002
    private var currentDocumentType: String? = null
    private val uploadedDocuments = mutableMapOf<String, Uri>()
    private val landData = LandData.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landdocuments_activity)

        val backButton: ImageButton = findViewById(R.id.backButton)
        val submitButton: Button = findViewById(R.id.submitButton)
        val uploadButton: Button = findViewById(R.id.uploadButton)

        // Back button
        backButton.setOnClickListener { finish() }

        // Initially disable submit
        submitButton.isEnabled = false
        submitButton.setBackgroundColor(resources.getColor(android.R.color.darker_gray))

        // Setup upload click listeners
        setupDocumentUploadListeners()

        // Upload button click
        uploadButton.setOnClickListener {
            handleUploadButtonClick()
        }

        // Submit button click
        submitButton.setOnClickListener {
            submitFullLandListing()
        }
    }

    private fun setupDocumentUploadListeners() {
        findViewById<LinearLayout>(R.id.adangal).setOnClickListener {
            currentDocumentType = "Adangal"
            selectFileToUpload(currentDocumentType!!)
        }

        findViewById<LinearLayout>(R.id.oneB).setOnClickListener {
            currentDocumentType = "One-B"
            selectFileToUpload(currentDocumentType!!)
        }

        findViewById<LinearLayout>(R.id.soilHealthCard).setOnClickListener {
            currentDocumentType = "Soil Health Card"
            selectFileToUpload(currentDocumentType!!)
        }

        findViewById<LinearLayout>(R.id.passbook).setOnClickListener {
            currentDocumentType = "Passbook"
            selectFileToUpload(currentDocumentType!!)
        }
    }

    private fun selectFileToUpload(documentType: String) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        startActivityForResult(intent, RC_UPLOAD_FILE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_UPLOAD_FILE && resultCode == RESULT_OK) {
            val fileUri: Uri? = data?.data
            if (fileUri != null) {
                handleFileUpload(fileUri)
            }
        }
    }

    private fun handleFileUpload(fileUri: Uri) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                currentDocumentType?.let { docType ->
                    uploadedDocuments[docType] = fileUri
                    Toast.makeText(
                        this@LandDocumentsActivity,
                        "$docType uploaded successfully",
                        Toast.LENGTH_SHORT
                    ).show()
                    checkEnableSubmit()
                }
            } catch (e: Exception) {
                Toast.makeText(
                    this@LandDocumentsActivity,
                    "Error uploading file: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun checkEnableSubmit() {
        val submitButton: Button = findViewById(R.id.submitButton)
        if (uploadedDocuments.size == 4) {
            submitButton.isEnabled = true
            submitButton.setBackgroundColor(resources.getColor(android.R.color.holo_green_dark))
        } else {
            submitButton.isEnabled = false
            submitButton.setBackgroundColor(resources.getColor(android.R.color.darker_gray))
        }
    }

    private fun handleUploadButtonClick() {
        if (uploadedDocuments.size < 4) {
            Toast.makeText(this, "Please upload all required documents", Toast.LENGTH_SHORT).show()
            return
        }
        checkEnableSubmit()
    }

    private fun submitFullLandListing() {
        landData.documents = uploadedDocuments["Adangal"]?.toString() ?: ""
        landData.healthCard = uploadedDocuments["Soil Health Card"]?.toString() ?: ""


        LandData.clearInstance()
        finish()
    }
}
