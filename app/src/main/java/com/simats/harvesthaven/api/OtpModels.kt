package com.simats.harvesthaven.api

data class SendOtpRequest(
    val phone: String
)

data class SendOtpResponse(
    val success: Boolean,
    val message: String
)

data class VerifyOtpRequest(
    val phone: String,
    val otp: String
)

data class VerifyOtpResponse(
    val success: Boolean,
    val message: String
)