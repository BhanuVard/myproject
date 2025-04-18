package com.simats.harvesthaven

import com.simats.harvesthaven.models.YearlyProfit

class LandData private constructor() {
    var photos: List<String>? = null
    var previousUse: String? = null
    var amenities: List<String>? = null
    var restrictions: List<String>? = null
    var yearlyProfits: List<YearlyProfit>? = null
    var documents: String? = null
    var healthCard: String? = null

    companion object {
        @Volatile
        private var instance: LandData? = null

        fun getInstance(): LandData {
            return instance ?: synchronized(this) {
                instance ?: LandData().also { instance = it }
            }

        }

        fun clearInstance() {
            instance = null
        }
        }
    }

