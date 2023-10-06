package com.mobile.traktorin.feature_order.domain.usecase

data class OrderUseCase(
    val getOrderForUser:GetOrderForUserUseCase,
    val getDetailOrderUseCase:GetDetailOrderUseCase
)