package com.mobile.traktorin.feature_auth.presentation.login

import com.mobile.traktorin.feature_auth.presentation.regis.RegisterEvent

sealed class LoginEvent {
    data class EnteredEmail(val email: String):LoginEvent()
    data class EnteredPassword(val password:String):LoginEvent()
    object TogglePasswordVisibility: LoginEvent()
    object Login:LoginEvent()
}