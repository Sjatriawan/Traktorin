package com.mobile.traktorin.feature_search.presentation.main_feed

sealed class MainFeedEvent {
    object LoadingMorePosts:MainFeedEvent()
    object LoadedPage:MainFeedEvent()
}