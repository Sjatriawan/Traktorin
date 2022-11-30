package com.mobile.traktorin.feature_service.presentation.create_servis

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import coil.annotation.ExperimentalCoilApi
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.states.StandardTextFieldState
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.UiEvent
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_search.domain.use_case.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateServiceViewModel @Inject constructor(
    private val postUseCase: PostUseCase
): ViewModel(){

    private val _isLoading = mutableStateOf(false)
    val isLoading:State<Boolean> = _isLoading

    private val _fullNameState = mutableStateOf(StandardTextFieldState())
    val fullNameState: State<StandardTextFieldState> = _fullNameState

    private val _priceState = mutableStateOf(StandardTextFieldState())
    val priceState: State<StandardTextFieldState> = _priceState

    private val _descriptionState = mutableStateOf(StandardTextFieldState())
    val descriptionState: State<StandardTextFieldState> = _descriptionState

    private val _villageState = mutableStateOf(StandardTextFieldState())
    val villageState: State<StandardTextFieldState> = _villageState

    private val _districtState = mutableStateOf(StandardTextFieldState())
    val districtState: State<StandardTextFieldState> = _districtState

    private val _provinceState = mutableStateOf(StandardTextFieldState())
    val provinceState: State<StandardTextFieldState> = _provinceState

    private val _chosenImageUri = mutableStateOf<Uri?>(null)
    val chosenImageUri: State<Uri?> = _chosenImageUri

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()


    fun onEvent(event: CreateServiceEvent) {
        when (event) {
            is CreateServiceEvent.EnteredFullName -> {
                _fullNameState.value = fullNameState.value.copy(
                    text = event.value
                )
            }
            is CreateServiceEvent.EnteredPrice -> {
                _priceState.value = priceState.value.copy(
                    text = event.value
                )
            }
            is CreateServiceEvent.EnteredDescription -> {
                _descriptionState.value = descriptionState.value.copy(
                    text = event.value
                )
            }
            is CreateServiceEvent.EnteredVillage -> {
                _villageState.value = villageState.value.copy(
                    text = event.value
                )
            }
            is CreateServiceEvent.EnteredDistrict -> {
                _districtState.value = districtState.value.copy(
                    text = event.value
                )
            }
            is CreateServiceEvent.EnteredProvince -> {
                _provinceState.value = provinceState.value.copy(
                    text = event.value
                )
            }
            is CreateServiceEvent.PickImage -> {
                _chosenImageUri.value = event.uri
            }

            is CreateServiceEvent.PostImage -> {
                viewModelScope.launch{
                    _isLoading.value = true
                    val result = postUseCase.createPostUseCase(
                        imgFile = chosenImageUri.value,
                        fullname = fullNameState.value.text,
                        description = descriptionState.value.text,
                        village = villageState.value.text,
                        district = districtState.value.text,
                        province = provinceState.value.text,
                        price = priceState.value.text,
                    )
                    when(result){
                        is Resource.Success ->{
                            _eventFlow.emit(UiEvent.ShowSnackBar(
                                uiText = UiText.StringResource(R.string.post_created)
                            ))
                            _eventFlow.emit(UiEvent.NavigateUp)
                        }
                        is Resource.Error ->{
                            println("RESULT ERROR: $result")
                            _eventFlow.emit(UiEvent.ShowSnackBar(
                                result.uiText ?: UiText.unknownError()
                            ))
                        }
                    }
                    _isLoading.value = false
                }
            }
            else -> {}
        }

    }
}