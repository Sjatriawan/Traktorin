package com.mobile.traktorin.feature_order.domain.usecase

import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.feature_order.domain.repository.OrderRepository

class GetDetailOrderUseCase(
    private val repository: OrderRepository
) {
    suspend operator fun invoke(orderId:String): Resource<Booking> {
        return repository.getOrderDetail(orderId)
    }
}