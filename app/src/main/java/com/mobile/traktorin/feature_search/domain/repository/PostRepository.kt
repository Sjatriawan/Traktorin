package com.mobile.traktorin.feature_search.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.mobile.response.BasicApiResponse
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.feature_profile.domain.model.Profile
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    val posts:Flow<PagingData<Post>>

    suspend fun createPost(
        fullname:String,
        village:String,
        district: String,
        province:String,
        description: String,
        price:Double,
        imgFile: Uri,
    ):SimpleResource<Any?>

    suspend fun getPostDetail(
        postId:String
    ):Resource<Post>
}
