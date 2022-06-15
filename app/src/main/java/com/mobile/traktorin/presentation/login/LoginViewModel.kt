package com.mobile.traktorin.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(): ViewModel(){

    private val _usernameText = mutableStateOf("")
    val usernameText: State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText: State<String> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword:State<Boolean> = _showPassword

    private val _usernameError = mutableStateOf("")
    val usernameError:State<String> = _usernameError

    private val _passwordError = mutableStateOf("")
    val passwordError:State<String> = _passwordError

    fun setUsername(username:String){
        _usernameText.value = username
    }

    fun setPassword(password:String){
        _passwordText.value = password
    }

    fun setShowPassword(showPass:Boolean){
        _showPassword.value =showPass
    }

    fun setUsernameError(error:String){
        _usernameError.value = error
    }

    fun setPasswordError(error: String){
        _passwordError.value = error
    }
}