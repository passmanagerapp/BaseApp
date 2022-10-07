package com.akilincarslan.baseapp.repos

import android.content.Context
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.models.Onboard
import javax.inject.Inject

class OnboardRepositoryImpl @Inject constructor(context:Context) :OnboardRepository{

    override suspend fun fetchOnboardList(): List<Onboard> {
        return listOf(
            Onboard(R.drawable.ic_launcher_foreground,"Read quotes of philosophers","With an amazing design, read and think about the quotes of philosophers."),
            Onboard(R.drawable.ic_launcher_foreground,"Look at the clips of movies with subtitles","Check and read the details of a movie from a movie clip."),
            Onboard(R.drawable.ic_launcher_foreground,"Filter by country,date","Filter the movies and philosophers by date or country"),
        )
    }
}