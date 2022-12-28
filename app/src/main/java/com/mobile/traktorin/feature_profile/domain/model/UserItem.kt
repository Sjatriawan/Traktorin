package com.mobile.traktorin.feature_profile.domain.model

data class UserItem (
    val userId:String,
    val username:String,
    val fullname:String,
    val village:String,
    val district:String,
    val province:String,
    val userPhone:Long,
    val postCount: Int = 0,
    val email:String,
    val profileImgUrl:String,
    val isService:Boolean = false,
){
    fun toUser():UserItem{
        return UserItem(
            userId = userId,
            username = username,
            fullname = fullname,
            village = village,
            district = district,
            province = province,
            userPhone = userPhone,
            postCount = postCount,
            email = email,
            profileImgUrl = profileImgUrl
        )
    }
}