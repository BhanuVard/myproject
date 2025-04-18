//package com.simats.harvesthaven
//
//import android.content.Context
//import android.net.Uri
//import com.google.api.services.drive.Drive
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.withContext
//import java.io.IOException
//
//class DriveServiceHelper(private val driveService: Drive) {
//    suspend fun uploadFile(fileName: String, fileUri: Uri, context: Context): String? {
//        return withContext(Dispatchers.IO) {
//            try {
//                val inputStream = context.contentResolver.openInputStream(fileUri)
//                val fileMetadata = com.google.api.services.drive.model.File()
//                    .setName(fileName)
//
//                val mediaContent = com.google.api.client.http.InputStreamContent(
//                    "application/octet-stream",
//                    inputStream
//                )
//
//                val file = driveService.files().create(fileMetadata, mediaContent)
//                    .setFields("id")
//                    .execute()
//
//                file.id
//            } catch (e: IOException) {
//                e.printStackTrace()
//                null
//            }
//        }
//    }
//}