package com.simats.harvesthaven.api

import com.simats.harvesthaven.models.LandPost
import retrofit2.Response
import retrofit2.http.*

interface LandService {
    @GET("api/lands")
    suspend fun getAllLands(): Response<List<LandPost>>

    @GET("api/lands/{id}")
    suspend fun getLandById(@Path("id") landId: String): Response<LandPost>

    @GET("api/lands/owner/{ownerId}")
    suspend fun getLandsByOwnerId(@Path("ownerId") ownerId: String): Response<List<LandPost>>

    @POST("api/lands")
    suspend fun createLandPost(@Body landPost: LandPost): Response<LandPost>

    @PUT("api/lands/{id}")
    suspend fun updateLandPost(
        @Path("id") landId: String,
        @Body landPost: LandPost
    ): Response<LandPost>

    @DELETE("api/lands/{id}")
    suspend fun deleteLandPost(@Path("id") landId: String): Response<Unit>

    @GET("api/lands/search")
    suspend fun searchLands(
        @Query("location") location: String? = null,
        @Query("minPrice") minPrice: Double? = null,
        @Query("maxPrice") maxPrice: Double? = null,
        @Query("minArea") minArea: Double? = null,
        @Query("maxArea") maxArea: Double? = null,
        @Query("soilType") soilType: String? = null,
        @Query("waterSource") waterSource: String? = null,
        @Query("cropType") cropType: String? = null
    ): Response<List<LandPost>>
}