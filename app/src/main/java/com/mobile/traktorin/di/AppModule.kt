package com.mobile.traktorin.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.util.JsonToken
import com.google.gson.Gson
import com.mobile.traktorin.core.presentation.util.Constant
import com.mobile.traktorin.feature_auth.domain.repository.AuthRepository
import com.mobile.traktorin.feature_auth.domain.usecase.LoginUseCase
import com.mobile.traktorin.feature_auth.domain.usecase.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPref(app: Application): SharedPreferences {
        return app.getSharedPreferences(
            Constant.SHARED_PREF_NAME,
            MODE_PRIVATE
        )
    }

    @Provides
    @Singleton
    fun provideJwtToken(sharedPreferences: SharedPreferences): String {
        return sharedPreferences.getString(Constant.KEY_JWT_TOKEN,"") ?: ""
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(sharedPreferences: SharedPreferences): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor{
                val token = sharedPreferences.getString(Constant.KEY_JWT_TOKEN,"")
                val modifiedRequest = it.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer $token")
                    .build()
                it.proceed(modifiedRequest)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideGson():Gson{
        return Gson()
    }

}