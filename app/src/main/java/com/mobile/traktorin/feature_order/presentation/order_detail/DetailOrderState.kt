package com.mobile.traktorin.feature_order.presentation.order_detail

import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.domain.models.Post

data class DetailOrderState(
    val order:Booking? = null,
    val isLoadingOrder:Boolean = false
)
