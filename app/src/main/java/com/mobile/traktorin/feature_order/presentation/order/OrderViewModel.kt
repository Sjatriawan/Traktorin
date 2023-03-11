package com.mobile.traktorin.feature_order.presentation.order

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import com.mobile.traktorin.core.domain.states.StandardTextFieldState
import com.mobile.traktorin.core.presentation.components.StandardTextField
import com.mobile.traktorin.core.presentation.components.StandardToolbar
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