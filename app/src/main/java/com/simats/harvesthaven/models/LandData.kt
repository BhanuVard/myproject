package com.simats.harvesthaven.models

data class LandData(
    var landType: String = "",
    var landArea: String = "",
    var location: String = "",
    var soilType: String = "",
    var cropsCultivated: List<String> = listOf(),
    var price: Double = 0.0,
    var status: String = "Sell",
    var documents: String = "",
    var healthCard: String = "",
    var previousProfits: String = "",
    var photos: List<String> = listOf(),
    var landHistory: String = ""
) {
    fun validate(): Boolean {
        return landType.isNotBlank() &&
               landArea.isNotBlank() &&
               location.isNotBlank() &&
               soilType.isNotBlank() &&
               price > 0.0
    }

    companion object {
        @Volatile
        private var instance: LandData? = null
        private val LOCK = Any()

        fun getInstance(): LandData =
            instance ?: synchronized(LOCK) {
                instance ?: LandData().also { instance = it }
            }

        fun clearInstance() {
            synchronized(LOCK) {
                instance = null
            }
        }
    }
}