package com.mobile.traktorin.feature_favorite.domain.repository

import androidx.paging.PagingData
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.SimpleResource
import kotlinx.coroutines.flow.Flow

interface FavoriteRepository {
    val favorites: Flow<PagingData<Favorite>>
    suspend fun addFavorite(favorite: Favorite): SimpleResource<Any?>
    suspend fun removeFavorite(userId: String, postId: String): SimpleResource<Any?>
    suspend fun getFavoriteDetail(
        postId:String
    ): Resource<Favorite>

}
