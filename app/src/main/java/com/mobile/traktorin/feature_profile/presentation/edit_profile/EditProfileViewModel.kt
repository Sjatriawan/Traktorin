package com.mobile.traktorin.feature_profile.presentation.edit_profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mobile.traktorin.core.presentation.components.StandarTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditProfileViewModel @Inject constructor(): ViewModel(){

    private val _usernameState = mutableStateOf(StandarTextFieldState())
    val usernameState:State<StandarTextFieldState> = _usernameState

    private val _addressState = mutableStateOf(StandarTextFieldState())
    val addressState:State<StandarTextFieldState> = _addressState

    private val _numberPhone = mutableStateOf(StandarTextFieldState())
    val phoneNumber:State<StandarTextFieldState> = _numberPhone

    fun setUsernameState(state: StandarTextFieldState){
        _usernameState.value = state
    }

    fun setAddressState(state: StandarTextFieldState){
        _addressState.value = state
    }

    fun setNumberState(state: StandarTextFieldState){
        _numberPhone.value  = state
    }
}