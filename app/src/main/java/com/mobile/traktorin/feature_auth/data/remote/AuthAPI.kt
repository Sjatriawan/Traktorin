package com.mobile.traktorin.feature_auth.data.remote

import com.mobile.data.request.CreateAccountRequest
import com.mobile.data.request.LoginRequest
import com.mobile.response.BasicApiResponse
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.feature_auth.data.dto.response.AuthResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface AuthAPI {
    @POST("/api/user/create")
    suspend fun register (
        @Body request: CreateAccountRequest
    ):BasicApiResponse<Unit>


    @POST("/api/user/login")
    suspend fun login(
        @Body request: LoginRequest
    ):BasicApiResponse<AuthResponse>

    @GET("/api/user/authenticate")
    suspend fun authenticate()


    companion object{
        const val BASE_URL = "http://192.168.37.78:8001/"
    }
}