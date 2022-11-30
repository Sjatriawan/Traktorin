package com.mobile.traktorin.feature_profile.domain.use_case

import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.feature_profile.domain.repository.ProfileRepository
import com.mobile.traktorin.feature_profile.domain.model.Profile

class GetProfileUseCase(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke(userId:String):Resource<Profile>{
        return repository.getProfile(userId)
    }
}