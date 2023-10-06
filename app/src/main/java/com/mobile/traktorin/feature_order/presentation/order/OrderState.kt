package com.mobile.traktorin.feature_order.presentation.order

data class OrderState(
    val isLoadingFirstTime:Boolean = true,
    val isLoadingNewOrder:Boolean = false,
)