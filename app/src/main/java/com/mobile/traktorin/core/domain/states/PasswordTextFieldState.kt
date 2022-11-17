package com.mobile.traktorin.core.domain.states

data class PasswordTextFieldState(
    val text:String = "",
    val error:Error? = null,
    val isPasswordVisible:Boolean = false
)
