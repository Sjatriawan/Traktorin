package com.mobile.traktorin.core.domain.Util

import android.util.Patterns
import com.mobile.traktorin.core.presentation.util.Constant
import com.mobile.traktorin.feature_auth.domain.model.AuthError
import com.mobile.traktorin.feature_auth.presentation.regis.RegisterEvent

object ValidationUtil {


    fun validationEmail(email:String):AuthError?{
        val trimmedEmail = email.trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            return AuthError.InvalidEmail
        }

        if (trimmedEmail.isBlank()){
            return AuthError.FieldEmpty
        }
        return null
    }

    fun validationUsername(username: String):AuthError?{
        val trimmedUsername = username.trim()
        var usernameError:AuthError? = null
        if (trimmedUsername.length < Constant.MIN_USERNAME_LENGTH){
            return AuthError.InputTooShort
        }
        if(trimmedUsername.isBlank()){
            return AuthError.FieldEmpty
        }
        return null
    }

    fun validationPassword(password: String):AuthError?{
        var passwordError:AuthError? = null
        val capitalLettersInPassword = password.any(){it.isUpperCase()}
        val numberInPassword = password.any(){it.isDigit()}
        if (!capitalLettersInPassword || !numberInPassword){
            return AuthError.InvalidPassword
        }

        if (password.isBlank()){
            return AuthError.FieldEmpty
        }
        if(password.length < Constant.MIN_PASSWORD_LENGTH){
            return AuthError.InputTooShort
        }
        return null
    }
}