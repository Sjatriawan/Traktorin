package com.mobile.traktorin.feature_favorite.data.repository

import android.content.Context
import android.nfc.tech.MifareUltralight.PAGE_SIZE
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.compose.collectAsLazyPagingItems
import com.mobile.data.request.CreateFavoriteRequest
import com.mobile.traktorin.R
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.util.Constant
import com.mobile.traktorin.core.presentation.util.Resource
import com.mobile.traktorin.core.presentation.util.SimpleResource
import com.mobile.traktorin.core.presentation.util.UiText
import com.mobile.traktorin.feature_favorite.data.paging.FavoriteSource
import com.mobile.traktorin.feature_favorite.data.remote.FavAPI
import com.mobile.traktorin.feature_favorite.domain.repository.FavoriteRepository
import com.mobile.traktorin.feature_search.data.data_source.paging.PostSource
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException

class FavoriteRepositoryImpl(
    private val api: FavAPI,

) : FavoriteRepository {
    override val favorites: Flow<PagingData<Favorite>>
        get() = Pager(
            PagingConfig(pageSize = PAGE_SIZE, enablePlaceholders = false)
        ) {
           FavoriteSource(api)
        }.flow

    override suspend fun addFavorite(
        favorite: Favorite
    ): SimpleResource<Any?> {
        return try {
            val response = api.addingFavorite(CreateFavoriteRequest(
                favorite.price,
                favorite.fullname,
                favorite.village
            ))
            if (response.successful) {
                Resource.Success(Unit)
            } else {
                response.message?.let { msg ->
                    Resource.Error(UiText.DynamicString(msg))

                } ?:
                Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        } catch (e: Exception) {
            Resource.Error(
                uiText = UiText.StringResource(R.string.something_wrong)
            )
        }catch (e: IOException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.cannot_reach_the_server)
            )
        }
    }

    override suspend fun removeFavorite(userId: String, postId: String): SimpleResource<Any?> {
        TODO("Not yet implemented")
    }


    override suspend fun getFavoriteDetail(postId: String): Resource<Favorite> {
        return try {
            val response = api.getFavDetail(postId = postId)
            if (response.successful){
                Resource.Success(response.data)
            }else{
                response.message?.let{ msg ->
                    Resource.Error(UiText.DynamicString(msg))
                }?: Resource.Error(UiText.StringResource(R.string.error_unknown))
            }
        }catch (e:IOException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.cannot_reach_the_server)
            )
        }catch (e: HttpException){
            Resource.Error(
                uiText = UiText.StringResource(R.string.something_wrong)
            )
        }

    }

}
