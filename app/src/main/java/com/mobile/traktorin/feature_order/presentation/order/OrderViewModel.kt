package com.mobile.traktorin.feature_order.presentation.order

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mobile.traktorin.feature_favorite.presentation.favorite.FavoriteEvent
import com.mobile.traktorin.feature_favorite.presentation.favorite.FavoriteState
import com.mobile.traktorin.feature_order.domain.usecase.OrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class OrderViewModel @Inject constructor(
    private val orderUseCase: OrderUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {
    val orders = orderUseCase.getOrderForUser().cachedIn(viewModelScope)

    private val _state = mutableStateOf(OrderState())
    val state: State<OrderState> = _state

    fun onEvent(event: OrderEvent) {
        when (event) {
            is OrderEvent.LoadingMoreOrder ->{
                _state.value = state.value.copy(
                    isLoadingFirstTime  = true
                )
            }
            is OrderEvent.LoadedPage ->{
                _state.value = state.value.copy(
                    isLoadingNewOrder = false,
                    isLoadingFirstTime = false
                )
            }
        }
    }

}