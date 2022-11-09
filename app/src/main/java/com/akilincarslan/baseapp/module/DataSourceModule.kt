package com.akilincarslan.baseapp.module

import com.akilincarslan.baseapp.network.services.auth.AuthRemoteDataSource
import com.akilincarslan.baseapp.network.services.auth.AuthRemoteDataSourceImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    @Singleton
    fun providesAuthRemoteDataSource(
        auth:FirebaseAuth
    ) : AuthRemoteDataSource {
        return AuthRemoteDataSourceImpl(auth)
    }
}