package com.mobile.traktorin.feature_profile.data.remote.response

import com.mobile.traktorin.feature_profile.domain.model.Profile

data class ProfileResponse(
    val userId:String,
    val username:String,
    val fullname:String,
    val village:String,
    val district:String,
    val province:String,
    val userPhone:Long,
    val profileImgUrl:String,
    val isOwnProfile:Boolean
){
    fun toProfile(): Profile {
        return Profile(
            userId = userId,
            username = username,
            fullname = fullname,
            village = village,
            district = district,
            province = province,
            userPhone = userPhone,
            profileImgUrl = profileImgUrl,
            isOwnProfile = isOwnProfile
        )
    }
}