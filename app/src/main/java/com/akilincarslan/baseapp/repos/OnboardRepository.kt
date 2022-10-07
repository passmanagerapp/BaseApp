package com.akilincarslan.baseapp.repos

import com.akilincarslan.baseapp.models.Onboard

interface OnboardRepository {
    suspend fun fetchOnboardList() :List<Onboard>
}