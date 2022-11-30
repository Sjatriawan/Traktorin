package com.mobile.traktorin.feature_search.data.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mobile.traktorin.core.domain.models.Post
import com.mobile.traktorin.core.presentation.util.Constant
import com.mobile.traktorin.feature_search.data.data_source.remote.PostApi
import okio.IOException
import retrofit2.HttpException

class PostSource(
    private val api: PostApi
):PagingSource<Int, Post>() {
    override fun getRefreshKey(state: PagingState<Int, Post>): Int? {
        return state.anchorPosition
    }

    private var currentPage = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Post> {
        return try {
            val nextPage = params.key ?: currentPage
            val posts = api.getPostForHome(
                page = nextPage,
                pageSize = Constant.PAGE_SIZE_POSTS
            )

            LoadResult.Page(
                data = posts,
                prevKey = if (nextPage == 0) null else nextPage - 1,
                nextKey = if (posts.isEmpty()) null else currentPage + 1
            ).also { currentPage++ }
        }catch (e:IOException){
            return LoadResult.Error(e)
        }catch (e:HttpException){
            return LoadResult.Error(e)
        }
    }
}