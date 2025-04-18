package com.simats.harvesthaven.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import java.util.concurrent.TimeUnit
import kotlin.math.pow

object RetrofitClient {
    private const val PORT = "5000"
    private val BASE_URL: String
        get() = "http://192.168.31.42:$PORT/"

    private val networkInterceptor = Interceptor { chain ->
        val request = chain.request()
        val response = chain.proceed(request)
        when (response.code) {
            400 -> {
                val errorBody = response.body?.string()
                response.close()
                throw IOException("Bad Request - ${errorBody ?: "Invalid input data"}")
            }
            401 -> {
                response.close()
                throw IOException("Unauthorized - Please check your credentials")
            }
            404 -> {
                response.close()
                throw IOException("Not Found - The requested resource does not exist")
            }
            500 -> {
                response.close()
                throw IOException("Internal Server Error - Please try again later")
            }
            502 -> {
                response.close()
                throw IOException("Bad Gateway - Server might be down or unreachable")
            }
        }
        response
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private fun getSecureOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(networkInterceptor)
            .addInterceptor(loggingInterceptor)
            .addInterceptor { chain ->
                val request = chain.request()
                var retryCount = 0
                val maxRetries = 3
                var lastException: Exception? = null

                while (retryCount <= maxRetries) {
                    try {
                        if (retryCount > 0) {
                            val backoffDelay = (2.0.pow((retryCount - 1).toDouble()) * 1000).toLong()
                            android.util.Log.i("API Retry", "Waiting ${backoffDelay}ms before retry $retryCount")
                            Thread.sleep(backoffDelay)
                        }

                        val response = chain.proceed(request)
                        val responseBody = response.peekBody(Long.MAX_VALUE).string()
                        android.util.Log.d("API Response", "URL: ${request.url}, Response: $responseBody")
                        return@addInterceptor response

                    } catch (e: Exception) {
                        lastException = e
                        val errorMessage = when (e) {
                            is java.net.ConnectException -> "Connection failed - Server unreachable"
                            is java.net.SocketTimeoutException -> "Connection timed out"
                            is java.net.UnknownHostException -> "Unable to resolve host"
                            else -> e.message ?: "Unknown error occurred"
                        }

                        android.util.Log.e(
                            "API Error",
                            "URL: ${request.url}, Attempt: ${retryCount + 1}/$maxRetries, Error: $errorMessage"
                        )

                        if (retryCount == maxRetries) {
                            throw IOException("Failed to connect after $maxRetries attempts: $errorMessage", lastException)
                        }
                        retryCount++
                    }
                }

                throw IOException("Unexpected error in retry loop", lastException)
            }
            .build()
    }

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL.trim())
            .client(getSecureOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // ✅ Land API
    val landService: LandService by lazy {
        retrofit.create(LandService::class.java)
    }

    // ✅ General API (e.g. login)
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
