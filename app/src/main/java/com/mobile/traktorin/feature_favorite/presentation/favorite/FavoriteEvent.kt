package com.mobile.traktorin.feature_favorite.presentation.favorite

import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.feature_search.presentation.main_feed.MainFeedEvent

sealed class FavoriteEvent {
    object LoadingMoreFavorite: FavoriteEvent()
    object LoadedPage: FavoriteEvent()
}
