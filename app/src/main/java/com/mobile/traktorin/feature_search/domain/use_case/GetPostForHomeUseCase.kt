package com.mobile.traktorin.feature_search.domain.use_case

import androidx.paging.PagingData
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.feature_search.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow

class GetPostForHomeUseCase (
    private val repository: PostRepository
    ){
     operator fun invoke(): Flow<PagingData<Post>> {
        return repository.posts
    }
}