package com.mobile.traktorin.feature_auth.domain.repository


import com.mobile.traktorin.core.presentation.util.SimpleResource

interface AuthRepository {
    suspend fun register(
        email:String,
        username:String,
        password:String
    ):SimpleResource
}