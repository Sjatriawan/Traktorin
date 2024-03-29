package com.mobile.traktorin.feature_search.data.data_source.remote
import com.mobile.response.BasicApiResponse
import com.mobile.traktorin.core.domain.models.Post
import okhttp3.MultipartBody
import retrofit2.http.*

interface PostApi {

    @GET("/api/post/get")
    suspend fun getPostForHome(
        @Query("page") page:Int,
        @Query("pageSize") pageSize:Int
    ):List<Post>

    @Multipart
    @POST("/api/post/create")
    suspend fun createPost(
        @Part postData: MultipartBody.Part,
        @Part postImage: MultipartBody.Part
    ):BasicApiResponse<Unit>

    @GET("/api/post/detail")
    suspend fun getPostDetail(
        @Query("post_id") postId:String
    ):BasicApiResponse<Post>

    companion object{
            const val BASE_URL = "http://10.0.2.2:8002/"
    }
}