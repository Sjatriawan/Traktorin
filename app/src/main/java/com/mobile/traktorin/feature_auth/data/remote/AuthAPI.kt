package com.mobile.traktorin.feature_auth.data.remote

import com.mobile.data.request.CreateAccountRequest
import com.mobile.response.BasicApiResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthAPI {
    @POST("/api/user/create")
    suspend fun register (
        @Body request: CreateAccountRequest
    ):BasicApiResponse

    companion object{
        const val BASE_URL = "http://192.168.43.78:8001/"
    }
}