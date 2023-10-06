package com.mobile.traktorin.feature_order.presentation.order_detail

import android.util.Log
import com.mobile.traktorin.feature_search.presentation.detail_service.DetailFeedEvent


import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.traktorin.core.domain.states.StandardTextFieldState
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.UiEvent
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_order.domain.usecase.OrderUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderDetailViewModel @Inject constructor(
    private val orderUseCase: OrderUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(DetailOrderState())
    val state:State<DetailOrderState> = _state

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<String>("orderId")?.let { orderId ->
            loadOrderDetail(orderId)
        }
    }

    fun onEvent(event: DetailOrderEvent){
        when(event){
            is DetailOrderEvent.OrderDetail ->{

            }
        }
    }

    private fun loadOrderDetail(orderId: String) {
        viewModelScope.launch {
            Log.d("OrderDetailViewModel", "Loading order detail for orderId: $orderId")
            _state.value = state.value.copy(
                isLoadingOrder = true
            )
            val result = orderUseCase.getDetailOrderUseCase(orderId)
            when (result) {
                is Resource.Success -> {
                    Log.d("OrderDetailViewModel", "Order detail loaded successfully: ${result.data}")
                    _state.value = state.value.copy(
                        order = result.data,
                        isLoadingOrder = false
                    )
                }
                is Resource.Error -> {
                    _state.value.copy(
                        isLoadingOrder = false
                    )
                    _eventFlow.emit(
                        UiEvent.ShowSnackBar(
                            result.uiText ?: UiText.unknownError()
                        )
                    )
                }
            }
        }
    }


//    private fun loadOrderDetail(orderId:String){
//        viewModelScope.launch {
//            _state.value = state.value.copy(
//                isLoadingOrder = true
//            )
//            val result = orderUseCase.getDetailOrderUseCase(orderId)
//            when(result){
//                is Resource.Success ->{
//                    _state.value = state.value.copy(
//                        order = result.data,
//                        isLoadingOrder = false
//                    )
//                }
//                is Resource.Error ->{
//                    _state.value.copy(
//                        isLoadingOrder = false
//                    )
//                    _eventFlow.emit(
//                        UiEvent.ShowSnackBar(
//                            result.uiText ?: UiText.unknownError()
//                        )
//                    )
//                }
//            }
//        }
//    }
}