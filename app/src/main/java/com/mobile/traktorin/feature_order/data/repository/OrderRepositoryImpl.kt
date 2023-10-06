package com.mobile.traktorin.feature_order.data.repository

import android.content.Context
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_order.data.paging.OrderSource
import com.mobile.traktorin.feature_order.data.remote.OrderAPI
import com.mobile.traktorin.feature_order.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException

class OrderRepositoryImpl(
    private val api:OrderAPI,
    private val appContext: Context

): OrderRepository{
    override val orders : Flow <PagingData<Booking>>
    get() = Pager(
        PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false)
    ){
        OrderSource(api)
    }.flow

    override suspend fun addOrder(favorite: Booking): SimpleResource<Any?> {
        TODO("Not yet implemented")
    }

    override suspend fun removeOrder(userId: String, postId: String): SimpleResource<Any?> {
        TODO("Not yet implemented")
    }

    override suspend fun getOrderDetail(id: String): Resource<Booking> {
        return try {
            val response = api.getOrderDetail(orderId = id)
            if (response.successful){
                Resource.Success(response.data)
            }else{
                response.message?.let{ msg ->
                    Resource.Error(UiText.DynamicString(msg))
                }?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        }catch (e: IOException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.cannot_reach_the_server)
            )
        }catch (e: HttpException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.something_wrong)
            )
        }
    }

}