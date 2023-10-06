package com.mobile.traktorin.di

import com.mobile.traktorin.feature_favorite.data.remote.FavAPI
import com.mobile.traktorin.feature_favorite.data.repository.FavoriteRepositoryImpl
import com.mobile.traktorin.feature_favorite.domain.repository.FavoriteRepository
import com.mobile.traktorin.feature_favorite.domain.usecase.FavoriteUseCase
import com.mobile.traktorin.feature_favorite.domain.usecase.GetDetailFavorite
import com.mobile.traktorin.feature_favorite.domain.usecase.GetFavoriteForUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FavoriteModule {

    @Provides
    @Singleton
    fun provideProfileApi(client: OkHttpClient): FavAPI {
        return Retrofit.Builder()
            .baseUrl(FavAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(FavAPI::class.java)

    }

//    @Provides
//    @Singleton
//    fun provideCreateFavoriteUseCase(repository: FavoriteRepository): CreateFavoriteUseCase {
//        return CreateFavoriteUseCase(repository)
//    }

    @Provides
    @Singleton
    fun provideFavoriteRepository(api: FavAPI): FavoriteRepository {
        return FavoriteRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideFavoriteUseCase(repository: FavoriteRepository):FavoriteUseCase{
        return FavoriteUseCase(
//            addingFavorite = CreateFavoriteUseCase(repository),
            getFavoriteForUser = GetFavoriteForUserUseCase(repository),
            getDetailFavorite = GetDetailFavorite(repository)
        )
    }




}