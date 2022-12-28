package com.mobile.traktorin.feature_profile.data.remote

import com.mobile.response.BasicApiResponse
import com.mobile.traktorin.feature_profile.data.remote.response.ProfileResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileApi{


    @GET("/api/user/profile")
       suspend fun getProfile(
           @Query("userId") userId:String
       ):BasicApiResponse<ProfileResponse>

    companion object{
        const val BASE_URL = "http://192.168.110.152:8001/"
    }
}