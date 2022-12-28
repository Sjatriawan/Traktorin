package com.mobile.traktorin.feature_service.data.dto.request

data class CreatePostRequest(
    val fullname:String,
    val village:String,
    val district:String,
    val province:String,
    val description:String,
    val price: Double,
    )

