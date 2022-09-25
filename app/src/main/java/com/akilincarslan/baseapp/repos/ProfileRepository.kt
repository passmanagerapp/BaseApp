package com.akilincarslan.baseapp.repos

import com.akilincarslan.baseapp.network.responses.ProfileResponse

interface ProfileRepository {
    suspend fun fetchProfileInfo():ProfileResponse
}