package com.akilincarslan.baseapp.network.services.profile

import com.akilincarslan.baseapp.network.responses.ProfileResponse

interface ProfileRemoteDataSource {
    suspend fun fetchProfileInfo(): ProfileResponse
}