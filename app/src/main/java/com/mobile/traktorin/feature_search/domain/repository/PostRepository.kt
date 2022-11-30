package com.mobile.traktorin.feature_search.domain.repository

import android.net.Uri
import androidx.paging.PagingData
import com.mobile.traktorin.core.domain.models.Post
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
        price:String,
        imgFile: Uri,
    ):SimpleResource
}
//{
//        fun toPost():Post  {
//            return Post(
//                fullname = fullname,
//                village = village,
//                district = district,
//                province = province,
//                description = description,
//                price = price,
//                timestamp = System.currentTimeMillis()
//            )
//        }