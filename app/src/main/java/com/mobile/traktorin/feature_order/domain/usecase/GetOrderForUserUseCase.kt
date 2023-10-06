package com.mobile.traktorin.feature_order.domain.usecase

import androidx.paging.PagingData
import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.feature_favorite.domain.repository.FavoriteRepository
import com.mobile.traktorin.feature_order.domain.repository.OrderRepository
import kotlinx.coroutines.flow.Flow

class GetOrderForUserUseCase (
    private val repository: OrderRepository
){
    operator fun invoke(): Flow<PagingData<Booking>> {
        return repository.orders
    }
}