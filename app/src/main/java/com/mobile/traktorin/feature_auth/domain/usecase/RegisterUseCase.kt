package com.mobile.traktorin.feature_auth.domain.usecase

import android.util.Patterns
import com.mobile.traktorin.core.domain.Util.ValidationUtil
import com.mobile.traktorin.core.presentation.util.Constant
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.feature_auth.domain.model.AuthError
import com.mobile.traktorin.feature_auth.domain.model.RegisterResult
import com.mobile.traktorin.feature_auth.domain.repository.AuthRepository

class RegisterUseCase (
    private val repository: AuthRepository
    ){
    suspend operator fun invoke(
        email:String,
        username:String,
        password:String
    ):RegisterResult{
        val emailError = ValidationUtil.validationEmail(email)
        val usernameError = ValidationUtil.validationUsername(username)
        val passwordError = ValidationUtil.validationPassword(password)

        if (emailError != null || usernameError !=null || passwordError !=null){
            return RegisterResult(
                emailError = emailError,
                usernameError = usernameError,
                passwordError = passwordError,

            )
        }

        val result = repository.register(email.trim(), username.trim(), password.trim())

        return RegisterResult(
            result  = result
        )
    }
}