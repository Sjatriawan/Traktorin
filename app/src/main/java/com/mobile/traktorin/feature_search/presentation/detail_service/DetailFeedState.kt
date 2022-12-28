package com.mobile.traktorin.feature_search.presentation.detail_service

import com.mobile.traktorin.core.domain.models.Post

data class DetailFeedState(
    val post: Post? = null,
    val isLoadingPost:Boolean = false
)