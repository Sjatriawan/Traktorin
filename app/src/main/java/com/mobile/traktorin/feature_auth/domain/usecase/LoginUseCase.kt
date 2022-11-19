package com.mobile.traktorin.feature_auth.domain.usecase

import com.mobile.data.request.LoginRequest
import com.mobile.traktorin.core.domain.Util.ValidationUtil
import com.mobile.traktorin.feature_auth.domain.model.AuthError
import com.mobile.traktorin.feature_auth.domain.model.LoginResult
import com.mobile.traktorin.feature_auth.domain.repository.AuthRepository

class LoginUseCase (
    private val repository: AuthRepository
    ){

    suspend operator fun invoke(email:String, password:String):LoginResult{
        val emailError = if (email.isBlank()) AuthError.FieldEmpty else null
        val passwordError = if (password.isBlank()) AuthError.FieldEmpty else null

        if (emailError != null || passwordError != null){
            return LoginResult(emailError, passwordError)
        }
        return LoginResult(
            result = repository.login(email,password)
        )
    }
}