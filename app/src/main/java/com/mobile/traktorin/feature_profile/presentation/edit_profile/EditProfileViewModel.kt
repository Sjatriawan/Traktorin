//package com.mobile.traktorin.feature_profile.presentation.edit_profile
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.mutableStateOf
//import androidx.lifecycle.ViewModel
//import com.mobile.traktorin.core.presentation.components.StandarTextFieldState
//
//import dagger.hilt.android.lifecycle.HiltViewModel
//import javax.inject.Inject
//
//@HiltViewModel
//class EditProfileViewModel @Inject constructor(
//):ViewModel(){
//    private val _usernameState = mutableStateOf(StandarTextFieldState())
//    val usernameState:State<StandarTextFieldState> = _usernameState
//
//    private val _emailState = mutableStateOf(StandarTextFieldState())
//    val emailState:State<StandarTextFieldState> = _emailState
//
//    private val _villageState = mutableStateOf(StandarTextFieldState())
//    val villageState:State<StandarTextFieldState> = _villageState
//
//    private val _districtState = mutableStateOf(StandarTextFieldState())
//    val districtState:State<StandarTextFieldState> = _districtState
//
//    private val _provinceState = mutableStateOf(StandarTextFieldState())
//    val provinceState:State<StandarTextFieldState> = _provinceState
//
//    private val _numberPhone = mutableStateOf(StandarTextFieldState())
//    val phoneNumber:State<StandarTextFieldState> = _numberPhone
//
//    fun setUsernameState(state: StandarTextFieldState){
//        _usernameState.value = state
//    }
//
//    fun setEmailState(state: StandarTextFieldState){
//        _emailState.value = state
//    }
//
//    fun setVillageState(state: StandarTextFieldState){
//        _villageState.value = state
//    }
//
//    fun setDistrictState(state: StandarTextFieldState){
//        _districtState.value = state
//    }
//
//    fun setProvinceState(state: StandarTextFieldState){
//        _emailState.value = state
//    }
//
//    fun setNumberState(state: StandarTextFieldState){
//        _numberPhone.value  = state
//    }
//}