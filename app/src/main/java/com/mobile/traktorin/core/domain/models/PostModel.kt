package com.mobile.traktorin.core.domain.models

data class PostModel(
    val fullname:String,
    val village:String,
    val district:String,
    val province:String,
    val imageUrl:String,
    val timestamp:Long,
    val description:String,
    val price: Double?,
)