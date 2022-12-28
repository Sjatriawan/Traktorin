package com.mobile.traktorin.feature_search.domain.use_case

import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.feature_search.domain.repository.PostRepository

class GetPostDetailUseCase(
    private val repository: PostRepository
) {
    suspend operator fun invoke(postId:String):Resource<Post>{
        return repository.getPostDetail(postId)
    }
}