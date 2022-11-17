package com.mobile.traktorin.di

import com.mobile.traktorin.feature_auth.data.remote.AuthAPI
import com.mobile.traktorin.feature_auth.data.repository.AuthRepositoryImpl
import com.mobile.traktorin.feature_auth.domain.repository.AuthRepository
import com.mobile.traktorin.feature_auth.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun provideAuthApi():AuthAPI{
        return Retrofit.Builder()
            .baseUrl(AuthAPI.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthAPI):AuthRepository{
        return AuthRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideRegisterUseCase(repository: AuthRepository):RegisterUseCase{
        return RegisterUseCase(repository)
    }
}