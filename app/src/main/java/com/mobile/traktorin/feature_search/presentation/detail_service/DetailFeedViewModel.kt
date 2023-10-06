package com.mobile.traktorin.feature_search.presentation.detail_service

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.traktorin.core.domain.states.StandardTextFieldState
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.UiEvent
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_search.domain.use_case.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailFeedViewModel @Inject constructor(
    private val postUseCase: PostUseCase,
    savedStateHandle: SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(DetailFeedState())
    val state:State<DetailFeedState> = _state

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _descriptionState = mutableStateOf(StandardTextFieldState())
    val description:State<StandardTextFieldState> = _descriptionState

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    init {
        savedStateHandle.get<String>("postId")?.let { postId ->
            loadDetailFeed(postId)
        }
    }

    fun onEvent(event: DetailFeedEvent){
        when(event){
            is DetailFeedEvent.FavPost ->{

            }
        }
    }

    private fun loadDetailFeed(postId:String){
       viewModelScope.launch {
           _state.value = state.value.copy(
               isLoadingPost = true
           )
           val result = postUseCase.getPostDetailUseCase(postId)
           when(result){
               is Resource.Success ->{
                   _state.value = state.value.copy(
                       post = result.data,
                       isLoadingPost = false
                   )
               }
               is Resource.Error ->{
                   _state.value.copy(
                       isLoadingPost = false
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
}