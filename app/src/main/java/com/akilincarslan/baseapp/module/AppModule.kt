package com.akilincarslan.baseapp.module

import android.content.Context
import com.akilincarslan.baseapp.network.services.profile.ProfileRemoteDataSource
import com.akilincarslan.baseapp.network.services.profile.ProfileRemoteDataSourceImpl
import com.akilincarslan.baseapp.network.services.profile.ProfileService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesContext(@ApplicationContext context: Context) : Context {
        return context
    }
}