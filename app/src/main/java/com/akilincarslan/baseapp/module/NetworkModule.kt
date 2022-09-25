package com.akilincarslan.baseapp.module

import android.app.Application
import com.akilincarslan.baseapp.BuildConfig
import com.akilincarslan.baseapp.constants.NetworkConstant
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient) :Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideGson():Gson {
        return GsonBuilder()
            .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(application: Application) :OkHttpClient {
        val okHttpBuilder : OkHttpClient.Builder = OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .callTimeout(NetworkConstant.HTTP_CALL_TIMEOUT_SECOND.toLong(),TimeUnit.SECONDS)
            .connectTimeout(NetworkConstant.HTTP_CONNECTION_TIMEOUT_SECONDS.toLong(),TimeUnit.SECONDS)
            .readTimeout(NetworkConstant.HTTP_READ_TIMEOUT_SECONDS.toLong(),TimeUnit.SECONDS)
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpBuilder.addInterceptor(logging)
        }
        return okHttpBuilder.build()
    }
}