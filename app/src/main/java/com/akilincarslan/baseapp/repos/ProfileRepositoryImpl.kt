package com.akilincarslan.baseapp.repos

import com.akilincarslan.baseapp.network.responses.ProfileResponse
import com.akilincarslan.baseapp.network.services.profile.ProfileService

class ProfileRepositoryImpl(
    private val service: ProfileService
) : ProfileRepository {
    override suspend fun fetchProfileInfo(): ProfileResponse {
       return service.fetchUserProfile()
    }
}