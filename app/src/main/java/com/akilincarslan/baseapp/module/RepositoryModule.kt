package com.akilincarslan.baseapp.module

import android.content.Context
import com.akilincarslan.baseapp.network.services.auth.AuthRemoteDataSource
import com.akilincarslan.baseapp.repos.onboard.OnboardRepository
import com.akilincarslan.baseapp.repos.onboard.OnboardRepositoryImpl
import com.akilincarslan.baseapp.repos.auth.AuthRepository
import com.akilincarslan.baseapp.repos.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun providesOnboardRepository(context:Context) : OnboardRepository {
        return OnboardRepositoryImpl(context)
    }
    @Provides
    @Singleton
    fun providesAuthRepository(dataSource: AuthRemoteDataSource) : AuthRepository {
        return AuthRepositoryImpl(dataSource)
    }
}