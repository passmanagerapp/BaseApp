package com.akilincarslan.baseapp.network.services.profile

import com.akilincarslan.baseapp.network.responses.ProfileResponse

class ProfileRemoteDataSourceImpl(
    private val service: ProfileService
) : ProfileRemoteDataSource {
    override suspend fun fetchProfileInfo(): ProfileResponse {
        return service.fetchUserProfile()
    }
}