package com.mobile.traktorin.feature_order.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.mobile.traktorin.core.domain.models.Booking
import com.mobile.traktorin.core.domain.models.Favorite
import com.mobile.traktorin.core.presentation.util.Constant
import com.mobile.traktorin.feature_favorite.data.remote.FavAPI
import com.mobile.traktorin.feature_order.data.remote.OrderAPI
import retrofit2.HttpException
import java.io.IOException

class OrderSource(
    private val api: OrderAPI
): PagingSource<Int, Booking>() {
    override fun getRefreshKey(state: PagingState<Int, Booking>): Int? {
        return state.anchorPosition
    }

    private var currentPage = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Booking> {
        return try {
            val nextPage = params.key ?: currentPage
            val orders = api.getOrderForUser(
                page = nextPage,
                pageSize = Constant.PAGE_SIZE_POSTS
            )

            LoadResult.Page(
                data = orders,
                prevKey = if (nextPage == 0) null else nextPage - 1,
                nextKey = if (orders.isEmpty()) null else currentPage + 1
            ).also { currentPage++ }
        }catch (e: IOException){
            return LoadResult.Error(e)
        }catch (e: HttpException){
            return LoadResult.Error(e)
        }
    }
}