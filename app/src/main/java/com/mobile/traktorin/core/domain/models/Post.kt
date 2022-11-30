package com.mobile.traktorin.core.domain.models

data class Post(
    val username:String,
    val fullname: String,
    val village: String,
    val district: String,
    val province: String,
    val imageUrl: String,
    val description: String,
    val price: String,
)