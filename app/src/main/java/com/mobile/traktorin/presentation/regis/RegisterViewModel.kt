package com.mobile.traktorin.presentation.regis

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(): ViewModel(){

    private val _emailText = mutableStateOf("")
    val emailText: State<String> = _emailText

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _emailError = mutableStateOf("")
    val emailError: State<String> = _emailError

    private val _usernameError = mutableStateOf("")
    val usernameError: State<String> = _usernameError

    private val _passwordError = mutableStateOf("")
    val passwordError: State<String> = _passwordError

    fun setEmail(email:String){
        _emailText.value = email
    }

    fun setUsername(username:String){
        _usernameText.value = username
    }

    fun setPassword(password:String){
        _passwordText.value = password
    }

    fun setShowPassword(showPass:Boolean){
        _showPassword.value =showPass
    }

    fun setEmailError(error:String){
        _emailError.value = error
    }

    fun setUsernameError(error:String){
        _usernameError.value = error
    }

    fun setPasswordError(error: String){
        _passwordError.value = error
    }
}