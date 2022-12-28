package com.mobile.traktorin.feature_profile.domain.model


data class Profile(
    val userId:String,
    val username:String,
    val fullname:String,
    val village:String,
    val district:String,
    val province:String,
    val userPhone:Long,
    val profileImgUrl:String,
    val isOwnProfile:Boolean
)