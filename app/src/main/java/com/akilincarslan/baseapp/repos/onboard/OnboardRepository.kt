package com.akilincarslan.baseapp.repos.onboard

import com.akilincarslan.baseapp.models.Onboard

interface OnboardRepository {
    suspend fun fetchOnboardList() :List<Onboard>
}