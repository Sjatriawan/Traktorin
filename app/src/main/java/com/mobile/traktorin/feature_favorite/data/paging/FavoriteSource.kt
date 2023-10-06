package com.mobile.traktorin.feature_favorite.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.util.Constant
import com.mobile.traktorin.feature_favorite.data.remote.FavAPI
import com.mobile.traktorin.feature_search.data.data_source.remote.PostApi
import retrofit2.HttpException
import java.io.IOException

class FavoriteSource(
    private val api: FavAPI
): PagingSource<Int, Favorite>() {
    override fun getRefreshKey(state: PagingState<Int, Favorite>): Int? {
        return state.anchorPosition
    }

    private var currentPage = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Favorite> {
        return try {
            val nextPage = params.key ?: currentPage
            val posts = api.getFavoriteForUser(
                page = nextPage,
                pageSize = Constant.PAGE_SIZE_POSTS
            )

            LoadResult.Page(
                data = posts,
                prevKey = if (nextPage == 0) null else nextPage - 1,
                nextKey = if (posts.isEmpty()) null else currentPage + 1
            ).also { currentPage++ }
        }catch (e: IOException){
            return LoadResult.Error(e)
        }catch (e: HttpException){
            return LoadResult.Error(e)
        }
    }
}