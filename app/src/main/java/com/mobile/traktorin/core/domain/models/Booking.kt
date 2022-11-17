package com.mobile.traktorin.core.domain.models

data class Booking(
    var userName:String = " ",
    var timestamp:Long = System.currentTimeMillis(),
    var bookingId: Int = -1,
    var price:String= ""
)
