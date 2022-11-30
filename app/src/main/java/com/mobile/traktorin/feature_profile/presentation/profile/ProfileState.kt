package com.mobile.traktorin.feature_profile.presentation.profile

import com.mobile.traktorin.feature_profile.domain.model.Profile

data class ProfileState (
    val profile:Profile? = null,
    val isLoading:Boolean = false
)