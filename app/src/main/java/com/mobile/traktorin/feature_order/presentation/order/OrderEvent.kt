package com.mobile.traktorin.feature_order.presentation.order

sealed class OrderEvent {
    object LoadingMoreOrder: OrderEvent()
    object LoadedPage: OrderEvent()
}
