package com.akilincarslan.baseapp.network.services.profile

import com.akilincarslan.baseapp.constants.NetworkConstant
import com.akilincarslan.baseapp.network.responses.ProfileResponse
import retrofit2.http.GET

interface ProfileService {

    @GET(NetworkConstant.Endpoint.Home.PROFILE)
    suspend fun fetchUserProfile() : ProfileResponse
}