package com.mobile.traktorin.feature_favorite.domain.usecase

import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.feature_favorite.domain.repository.FavoriteRepository
import com.mobile.traktorin.feature_search.domain.repository.PostRepository

class GetDetailFavorite(
    private val repository: FavoriteRepository
) {
    suspend operator fun invoke(postId:String): Resource<Favorite> {
        return repository.getFavoriteDetail(postId)
    }
}