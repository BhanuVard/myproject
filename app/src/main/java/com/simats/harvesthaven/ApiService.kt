package com.simats.harvesthaven.api

import retrofit2.http.*
import retrofit2.Response
import com.simats.harvesthaven.models.LandPost

data class LoginRequest(
    val username: String,
    val password: String
)

data class LoginResponse(
    val message: String?,
    val token: String?
)

data class RegisterRequest(
    val name: String,
    val username: String,
    val email: String,
    val phone: String,
    val password: String
)

data class RegisterResponse(
    val message: String?
)

data class Land(
    val id: String,
    val owner: String,
    val title: String,
    val description: String,
    val landType: String,
    val area: Double,
    val areaUnit: String,
    val price: Double,
    val status: String,
    val location: Location,
    val soilType: String,
    val waterSource: List<String>?,
    val irrigation: Boolean,
    val cropsCultivated: List<String>?,
    val images: List<Image>?,
    val documents: List<Document>?,
    val healthCard: String?
)

data class Location(
    val address: String,
    val city: String,
    val state: String,
    val country: String,
    val coordinates: Coordinates?
)

data class Coordinates(
    val latitude: Double,
    val longitude: Double
)

data class Image(
    val url: String,
    val caption: String?
)

data class Document(
    val type: String,
    val url: String,
    val verified: Boolean
)

interface ApiService {
    @POST("api/users/login")
    suspend fun login(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @POST("api/owners/login")
    suspend fun ownerLogin(
        @Body request: LoginRequest
    ): Response<LoginResponse>

    @POST("api/users/register")
    suspend fun register(
        @Body request: RegisterRequest
    ): Response<RegisterResponse>

    @POST("api/owners/register")
    suspend fun registerOwner(
        @Body request: RegisterRequest
    ): Response<RegisterResponse>

    @POST("auth/sendotp")
    suspend fun sendOtp(
        @Body request: SendOtpRequest
    ): Response<SendOtpResponse>

    @GET("api/lands")
    suspend fun getLandListings(): Response<List<Land>>

    @GET("api/lands/all")
    suspend fun getAllLands(): Response<List<LandPost>>

    @GET("api/lands/{id}")
    suspend fun getLandById(@Path("id") id: String): Response<Land>

    @POST("api/lands")
    suspend fun addLand(@Body land: Land): Response<Land>

    @PUT("api/lands/{id}")
    suspend fun updateLand(@Path("id") id: String, @Body land: Land): Response<Land>

    @DELETE("api/lands/{id}")
    suspend fun deleteLand(@Path("id") id: String): Response<Unit>

    @POST("auth/verifyotp")
    suspend fun verifyOtp(
        @Body request: VerifyOtpRequest
    ): Response<VerifyOtpResponse>
}