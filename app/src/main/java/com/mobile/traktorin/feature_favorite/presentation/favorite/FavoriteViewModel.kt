package com.mobile.traktorin.feature_favorite.presentation.favorite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.feature_favorite.domain.usecase.FavoriteUseCase
import com.mobile.traktorin.feature_search.presentation.main_feed.MainFeedEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favoriteUseCase: FavoriteUseCase
) : ViewModel() {

    val favorites = favoriteUseCase.getFavoriteForUser().cachedIn(viewModelScope)

    private val _state = mutableStateOf(FavoriteState())
    val state: State<FavoriteState> = _state

    fun onEvent(event: FavoriteEvent) {
        when (event) {
            is FavoriteEvent.LoadingMoreFavorite ->{
                _state.value = state.value.copy(
                    isLoadingFirstTime  = true
                )
            }
            is FavoriteEvent.LoadedPage ->{
                _state.value = state.value.copy(
                    isLoadingNewFavorite = false,
                    isLoadingFirstTime = false
                )
            }
        }
    }

}
