package com.akilincarslan.baseapp.repos

import com.akilincarslan.baseapp.network.responses.ProfileResponse
import com.akilincarslan.baseapp.network.services.profile.ProfileRemoteDataSource
import com.akilincarslan.baseapp.network.services.profile.ProfileService
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProfileRemoteDataSource
) : ProfileRepository {

    override suspend fun fetchProfileInfo(): ProfileResponse {
        return remoteDataSource.fetchProfileInfo()
    }
}