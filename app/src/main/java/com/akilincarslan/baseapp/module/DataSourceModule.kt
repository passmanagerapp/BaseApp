package com.akilincarslan.baseapp.module

import com.akilincarslan.baseapp.network.services.profile.ProfileRemoteDataSource
import com.akilincarslan.baseapp.network.services.profile.ProfileRemoteDataSourceImpl
import com.akilincarslan.baseapp.network.services.profile.ProfileService
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
    fun providesProfileRemoteDataSource(
        service: ProfileService
    ) :ProfileRemoteDataSource {
        return ProfileRemoteDataSourceImpl(service)
    }
}