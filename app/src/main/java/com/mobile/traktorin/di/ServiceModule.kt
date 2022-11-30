package com.mobile.traktorin.di

import android.content.Context
import com.google.gson.Gson
import com.mobile.traktorin.feature_auth.data.remote.AuthAPI
import com.mobile.traktorin.feature_search.data.data_source.remote.PostApi
import com.mobile.traktorin.feature_search.data.repository.PostRepositoryImpl
import com.mobile.traktorin.feature_search.domain.repository.PostRepository
import com.mobile.traktorin.feature_search.domain.use_case.GetPostForHomeUseCase
import com.mobile.traktorin.feature_search.domain.use_case.PostUseCase
import com.mobile.traktorin.feature_search.domain.use_case.CreateServiceUseCase
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
object ServiceModule {

    @Provides
    @Singleton
    fun provideServiceApi(client: OkHttpClient): PostApi {
        return Retrofit.Builder()
            .baseUrl(PostApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PostApi::class.java)
    }


    @Provides
    @Singleton
    fun providePostRepository(
        api: PostApi,
        gson: Gson,
        @ApplicationContext appContext:Context
    ):PostRepository{
        return PostRepositoryImpl(api, gson, appContext)
    }

    @Provides
    @Singleton
    fun providePostUseCase(repository: PostRepository):PostUseCase{
        return PostUseCase(
            getPostForHomeUseCase = GetPostForHomeUseCase(repository),
            createPostUseCase = CreateServiceUseCase(repository)
        )
    }


}