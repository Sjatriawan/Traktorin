package com.mobile.traktorin.feature_search.presentation.main_feed

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import androidx.paging.cachedIn

import com.mobile.traktorin.feature_search.domain.use_case.PostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainFeedViewModel @Inject constructor(
    private val postUseCase: PostUseCase
):ViewModel(){

    private val _state = mutableStateOf(MainFeedState())
    val state:State<MainFeedState> =_state

    val posts = postUseCase.getPostForHomeUseCase().cachedIn(viewModelScope)

    fun onEvent(event: MainFeedEvent){
        when(event){
            is MainFeedEvent.LoadingMorePosts ->{
                _state.value = state.value.copy(
                    isLoadingFirstTime = true
                )
            }
            is MainFeedEvent.LoadedPage ->{
                _state.value = state.value.copy(
                    isLoadingFirstTime = false,
                    isLoadingNewPosts = false
                )
            }
        }
    }

}