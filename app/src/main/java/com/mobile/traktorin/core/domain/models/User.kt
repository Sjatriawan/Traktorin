package com.mobile.traktorin.core.domain.models

data class User (
    val userId:String,
    val username:String,
    val village:String,
    val district:String,
    val province:String,
    val userPhone:Long,
    val postCount: Int = 0,
    val email:String,
    val profileImgUrl:String,
    val isService:Boolean = false,
)