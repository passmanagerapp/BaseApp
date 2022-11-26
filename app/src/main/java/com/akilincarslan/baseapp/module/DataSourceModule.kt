package com.akilincarslan.baseapp.module

import com.akilincarslan.baseapp.network.services.auth.AuthRemoteDataSource
import com.akilincarslan.baseapp.network.services.auth.AuthRemoteDataSourceImpl
import com.akilincarslan.baseapp.network.services.home.HomeRemoteDataSource
import com.akilincarslan.baseapp.network.services.home.HomeRemoteDataSourceImpl
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
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

    @Provides
    @Singleton
    fun providesHomeRemoteDataSource(
        firebase:FirebaseFirestore
    ) : HomeRemoteDataSource {
        return HomeRemoteDataSourceImpl(firebase)
    }
}