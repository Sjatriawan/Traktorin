package com.mobile.traktorin.feature_profile.presentation.profile

sealed class ProfileEvent {
    data class GetProfile(val userId:String):ProfileEvent()
}