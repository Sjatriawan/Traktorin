package com.mobile.traktorin.core.domain.models

data class Favorite(
    val postId:String = "",
    val price: Double,
    val fullname: String,
    val village: String
)
