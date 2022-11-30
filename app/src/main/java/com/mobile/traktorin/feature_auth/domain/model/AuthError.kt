package com.mobile.traktorin.feature_auth.domain.model


sealed class AuthError:Error(){
    object FieldEmpty: AuthError()
    object InputTooShort: AuthError()
    object InvalidPassword : AuthError()
    object InvalidEmail : AuthError()
}

sealed class PostError:Error(){
    object FieldEmpty: PostError()

}