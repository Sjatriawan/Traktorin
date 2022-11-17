package com.mobile.traktorin.core.domain.states

data class StandardTextFieldState(
    val text:String = "",
    val error:Error? = null
)