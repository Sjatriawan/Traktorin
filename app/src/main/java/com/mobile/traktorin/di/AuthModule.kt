package com.mobile.traktorin.di

import android.content.SharedPreferences
import com.mobile.traktorin.feature_auth.data.remote.AuthAPI
import com.mobile.traktorin.feature_auth.data.repository.AuthRepositoryImpl
import com.mobile.traktorin.feature_auth.domain.repository.AuthRepository
import com.mobile.traktorin.feature_auth.domain.usecase.AuthenticateUseCase
import com.mobile.traktorin.feature_auth.domain.usecase.LoginUseCase
import com.mobile.traktorin.feature_auth.domain.usecase.RegisterUseCase
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
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthApi(client: OkHttpClient):AuthAPI{
        return Retrofit.Builder()
            .baseUrl(AuthAPI.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthAPI, sharedPreferences: SharedPreferences):AuthRepository{
        return AuthRepositoryImpl(api, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideRegisterUseCase(repository: AuthRepository):RegisterUseCase{
        return RegisterUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase {
        return LoginUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAuthenticateUseCase(repository: AuthRepository): AuthenticateUseCase {
        return AuthenticateUseCase(repository)
    }
}