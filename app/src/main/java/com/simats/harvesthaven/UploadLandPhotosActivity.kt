package com.simats.harvesthaven
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class UploadLandPhotosActivity : AppCompatActivity() {

    private lateinit var photoAdapter: PhotoAdapter
    private val PICK_IMAGE_REQUEST = 1
    private val landData = LandData.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.photoupload_activty)

        val uploadPhotoButton: Button = findViewById(R.id.uploadPhotoButton)
        val nextButton: Button = findViewById(R.id.nextButton)
        val photoRecyclerView: RecyclerView = findViewById(R.id.photoRecyclerView)

        photoAdapter = PhotoAdapter()
        photoRecyclerView.layoutManager = LinearLayoutManager(this)
        photoRecyclerView.adapter = photoAdapter

        uploadPhotoButton.setOnClickListener {
            openFileManager()
        }

        nextButton.setOnClickListener {
            if (photoAdapter.getPhotos().isEmpty()) {
                Toast.makeText(this, "Please upload at least one photo", Toast.LENGTH_SHORT).show()
            } else {
                landData.photos = photoAdapter.getPhotos().map { it.toString() }
                val intent = Intent(this, LandDocumentsActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun openFileManager() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true)
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            val clipData = data?.clipData
            if (clipData != null) {
                for (i in 0 until clipData.itemCount) {
                    val imageUri: Uri = clipData.getItemAt(i).uri
                    photoAdapter.addPhoto(imageUri)
                }
            } else if (data?.data != null) {
                val imageUri: Uri? = data.data
                if (imageUri != null) {
                    photoAdapter.addPhoto(imageUri)
                }
            }
        }
    }
}
