package com.akilincarslan.baseapp.repos

import android.content.Context
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.models.Onboard
import javax.inject.Inject

class OnboardRepositoryImpl @Inject constructor(val context:Context) :OnboardRepository{

    override suspend fun fetchOnboardList(): List<Onboard> {
        return listOf(
            Onboard(R.drawable.philosophy_1,context.getString(R.string.onboard_title1),context.getString(R.string.onboard_desc1)),
            Onboard(R.drawable.philosophy_2,context.getString(R.string.onboard_title2),context.getString(R.string.onboard_desc2)),
            Onboard(R.drawable.philosophy_3,context.getString(R.string.onboard_title3),context.getString(R.string.onboard_desc3)),
        )
    }
}