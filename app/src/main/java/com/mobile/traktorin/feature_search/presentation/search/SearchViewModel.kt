package com.mobile.traktorin.feature_search.presentation.search

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mobile.traktorin.core.presentation.components.StandarTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor():ViewModel() {
    private val _searchState = mutableStateOf(StandarTextFieldState())
    val searchState:State<StandarTextFieldState> = _searchState

    fun setSearchState(state: StandarTextFieldState){
        _searchState.value = state
    }
}