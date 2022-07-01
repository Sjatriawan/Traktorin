package com.mobile.traktorin.domain.models

import java.sql.Timestamp

data class Booking(
    var userName:String = " ",
    var timestamp:Long = System.currentTimeMillis(),
    var bookingId: Int = -1,
    var price:String= ""
)
