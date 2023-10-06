package com.mobile.traktorin.feature_auth.domain.model

import com.mobile.traktorin.core.presentation.util.SimpleResource

data class RegisterResult(
    val emailError: AuthError? = null,
    val usernameError: AuthError? = null,
    val passwordError:AuthError? = null,
    val result: SimpleResource<Any?>? = null
)