package com.mobile.traktorin.feature_order.data.remote

import com.mobile.data.request.CreateFavoriteRequest
import com.mobile.response.BasicApiResponse
import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.domain.models.Post
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface OrderAPI {


    @GET("/api/order/get")
    suspend fun getOrderForUser(
        @Query("page") page:Int,
        @Query("pageSize") pageSize:Int
    ):List<Booking>

    @GET("/api/order/detail")
    suspend fun getOrderDetail(
        @Query("order_id") orderId:String
    ):BasicApiResponse<Booking>

    companion object{
        const val BASE_URL = "http://10.0.2.2:8002/"
    }
}