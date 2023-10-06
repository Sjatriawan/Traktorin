package com.mobile.traktorin.feature_favorite.domain.usecase

import androidx.paging.PagingData
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.feature_favorite.domain.repository.FavoriteRepository
import kotlinx.coroutines.flow.Flow


//class CreateFavoriteUseCase(
//    private val repository: FavoriteRepository
//) {
//    operator fun invoke(): Flow<PagingData<Favorite>> {
//        return repository.favorites
//    }
//}
