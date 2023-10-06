package com.mobile.traktorin.feature_order.domain.repository

import androidx.paging.PagingData
import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.SimpleResource
import kotlinx.coroutines.flow.Flow

interface OrderRepository {
    val orders: Flow<PagingData<Booking>>
    suspend fun addOrder(order: Booking): SimpleResource<Any?>
    suspend fun removeOrder(userId: String, orderId: String): SimpleResource<Any?>


    suspend fun getOrderDetail(
        orderId:String
    ): Resource<Booking>
}