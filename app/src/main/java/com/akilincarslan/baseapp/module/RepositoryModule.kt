package com.akilincarslan.baseapp.module

import com.akilincarslan.baseapp.network.services.profile.ProfileService
import com.akilincarslan.baseapp.repos.ProfileRepository
import com.akilincarslan.baseapp.repos.ProfileRepositoryImpl
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
    fun providesProfileRepository(service: ProfileService) :ProfileRepository {
        return ProfileRepositoryImpl(service)
    }
}