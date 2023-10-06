package com.mobile.traktorin.core.domain.models

data class Booking(
    val id:String,
    val imageUrl:String,
    val address: String,
    val employee:String,
    val timestamp:Long = System.currentTimeMillis(),
    val are:Double
)
