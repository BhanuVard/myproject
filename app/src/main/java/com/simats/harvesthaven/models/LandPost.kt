package com.simats.harvesthaven.models

import com.simats.harvesthaven.api.Coordinates
import com.simats.harvesthaven.api.Document
import com.simats.harvesthaven.api.Image
import com.simats.harvesthaven.api.Location

data class LandPost(
    val id: String,
    val owner: String,
    val ownerName: String,
    val ownerContact: String,
    val landTitle: String,
    val title: String,
    val description: String,
    val landType: String,
    val area: Double,
    val areaUnit: String,
    val price: Double,
    val status: String,
    val isAvailable: Boolean = true,
    val location: Location,
    val soilType: String,
    val waterSource: List<String>?,
    val irrigation: Boolean,
    val cropTypes: List<String>,
    val cropsCultivated: List<String>?,
    val imageUrl: String,
    val images: List<Image>?,
    val documents: List<Document>?,
    val healthCard: String?,
    val previousUse: String? = null,
    val previousProfits: List<YearlyProfit>? = null,
    val yieldHistory: List<YearlyYield>? = null,
    val amenities: List<String>? = null,
    val restrictions: List<String>? = null,
    val createdAt: String,
    val updatedAt: String,
    val isVerified: Boolean = false,
    val isActive: Boolean = true,
    val views: Int = 0
)

data class YearlyProfit(
    val year: Int,
    val amount: Double,
    val crops: List<String>,
    val area: Double
)

data class YearlyYield(
    val year: Int,
    val cropType: String,
    val quantity: Double,
    val unit: String
)