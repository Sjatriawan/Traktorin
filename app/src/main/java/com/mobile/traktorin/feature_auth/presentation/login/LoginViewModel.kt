package com.mobile.traktorin.feature_auth.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.traktorin.core.domain.states.PasswordTextFieldState
import com.mobile.traktorin.core.domain.states.StandardTextFieldState
import com.mobile.traktorin.core.presentation.ui.util.Screen
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.UiEvent
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_auth.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel(){

    private val _emailState = mutableStateOf(StandardTextFieldState())
    val emailState: State<StandardTextFieldState> = _emailState

    private val _passwordState = mutableStateOf(PasswordTextFieldState())
    val passwordState: State<PasswordTextFieldState> = _passwordState

    private val _loginState = mutableStateOf(LoginState())
    val loginState:State<LoginState> = _loginState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun onEvent(event: LoginEvent){
        when(event){
            is LoginEvent.EnteredEmail ->{
                _emailState.value = _emailState.value.copy(
                    text = event.email
                )
            }
            is LoginEvent.EnteredPassword ->{
                _passwordState.value = _passwordState.value.copy(
                    text = event.password
                )
            }
            is LoginEvent.TogglePasswordVisibility->{
                _passwordState.value = _passwordState.value.copy(
                    isPasswordVisible = !_passwordState.value.isPasswordVisible
                )
            }
            is LoginEvent.Login ->{
               viewModelScope.launch {
                   _loginState.value= LoginState(isLoading = true)
                   val loginResult = loginUseCase(
                       email = emailState.value.text,
                       password = passwordState.value.text
                   )
                   _loginState.value= LoginState(isLoading = false)
                   if (loginResult.emailError != null){
                       _emailState.value = _emailState.value.copy(
                           error = loginResult.emailError
                       )
                   }

                   if (loginResult.passwordError != null){
                       _passwordState.value = _passwordState.value.copy(
                           error = loginResult.passwordError
                       )
                   }
                   when(loginResult.result){
                       is Resource.Success -> {
                           _eventFlow.emit(
                               UiEvent.Navigate(Screen.MainFeedScreen.route)
                           )
                       }
                       is Resource.Error -> {
                           _eventFlow.emit(
                               UiEvent.ShowSnackBar(loginResult.result.uiText ?: UiText.unknownError())
                           )
                           _loginState.value= LoginState(isLoading = false)
                       }
                       null -> {
                           _loginState.value= LoginState(isLoading = false)
                       }
                   }
               }
            }
        }
    }

}