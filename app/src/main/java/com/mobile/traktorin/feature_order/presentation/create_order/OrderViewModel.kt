package com.mobile.traktorin.feature_order.presentation.create_order

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mobile.traktorin.core.domain.states.StandardTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(

):ViewModel(){

    private val _surfaceArea = mutableStateOf(StandardTextFieldState())
    val surfaceArea: State<StandardTextFieldState> = _surfaceArea

    private val _note = mutableStateOf(StandardTextFieldState())
    val note:State<StandardTextFieldState> = _note

    private val _cash = MutableStateFlow(false)
    val cash: StateFlow<Boolean> = _cash

}