package com.mobile.traktorin.feature_profile.domain.repository

import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.feature_profile.domain.model.Profile

interface ProfileRepository {

    suspend fun getProfile(userId:String):Resource<Profile>
}