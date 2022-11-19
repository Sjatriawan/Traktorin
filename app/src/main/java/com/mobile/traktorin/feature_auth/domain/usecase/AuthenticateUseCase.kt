package com.mobile.traktorin.feature_auth.domain.usecase

import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.feature_auth.domain.repository.AuthRepository

class AuthenticateUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke():SimpleResource{
        return repository.authenticate()
    }
}
