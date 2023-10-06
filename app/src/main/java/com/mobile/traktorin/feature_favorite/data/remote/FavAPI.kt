package com.mobile.traktorin.feature_favorite.data.remote

import com.mobile.data.request.CreateAccountRequest
import com.mobile.data.request.CreateFavoriteRequest
import com.mobile.response.BasicApiResponse
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.domain.models.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface FavAPI {
    @POST("/api/user/create")
    suspend fun addingFavorite (
        @Body request: CreateFavoriteRequest
    ): BasicApiResponse<Unit>

    @GET("/api/favorite/get")
    suspend fun getFavoriteForUser(
        @Query("page") page:Int,
        @Query("pageSize") pageSize:Int
    ):List<Favorite>

    @GET("/api/post/detail")
    suspend fun getFavDetail(
        @Query("post_id") postId:String
    ):BasicApiResponse<Favorite>


    companion object{
        const val BASE_URL = "http://10.0.2.2:8002/"
    }
}
