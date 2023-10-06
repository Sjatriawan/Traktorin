package com.mobile.traktorin.di

import android.content.Context
import com.mobile.traktorin.feature_favorite.data.remote.FavAPI
import com.mobile.traktorin.feature_favorite.domain.repository.FavoriteRepository
import com.mobile.traktorin.feature_favorite.domain.usecase.FavoriteUseCase
import com.mobile.traktorin.feature_favorite.domain.usecase.GetDetailFavorite
import com.mobile.traktorin.feature_favorite.domain.usecase.GetFavoriteForUserUseCase
import com.mobile.traktorin.feature_order.data.remote.OrderAPI
import com.mobile.traktorin.feature_order.data.repository.OrderRepositoryImpl
import com.mobile.traktorin.feature_order.domain.repository.OrderRepository
import com.mobile.traktorin.feature_order.domain.usecase.GetDetailOrderUseCase
import com.mobile.traktorin.feature_order.domain.usecase.GetOrderForUserUseCase
import com.mobile.traktorin.feature_order.domain.usecase.OrderUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object OrderModule {

    @Provides
    @Singleton
    fun provideOrderApi(client: OkHttpClient): OrderAPI {
        return Retrofit.Builder()
            .baseUrl(OrderAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(OrderAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideOrderRepository(api: OrderAPI, @ApplicationContext appContext: Context
    ):OrderRepository{
        return OrderRepositoryImpl(api, appContext)
    }

    @Provides
    @Singleton
    fun provideOrderUseCase(repository: OrderRepository): OrderUseCase {
        return OrderUseCase(
//            addingFavorite = CreateFavoriteUseCase(repository),
            getOrderForUser = GetOrderForUserUseCase(repository),
            getDetailOrderUseCase = GetDetailOrderUseCase(repository)
    )
    }
}