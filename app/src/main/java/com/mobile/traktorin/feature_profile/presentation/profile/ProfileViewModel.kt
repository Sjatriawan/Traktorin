package com.mobile.traktorin.feature_profile.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.UiEvent
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_profile.domain.use_case.ProfileUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val profileUseCases: ProfileUseCases,
    savedStateHandle: SavedStateHandle
):ViewModel(){

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private val _state = mutableStateOf(ProfileState())
    val state:State<ProfileState> = _state

    init {
        savedStateHandle.get<String>("userId")?.let { userId ->
            getProfile(userId)
        }
    }

    fun onEvent(event:ProfileEvent){
        when(event){
            is ProfileEvent.GetProfile ->{

            }
        }
    }

    private fun getProfile(userId:String){
        viewModelScope.launch{
            _state.value = state.value.copy(
                isLoading = true
            )
            val result = profileUseCases.getProfile(userId)
            when (result){
                is Resource.Success ->{
                    _state.value = state.value.copy(
                        profile = result.data,
                        isLoading = false
                    )
                }
                is Resource.Error ->{
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                    _eventFlow.emit(
                        UiEvent.ShowSnackBar(
                            uiText = result.uiText?: UiText.unknownError()
                        )
                    )
                }
            }
        }

    }
}