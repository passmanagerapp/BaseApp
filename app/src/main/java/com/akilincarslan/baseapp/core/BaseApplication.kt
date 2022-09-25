package com.akilincarslan.baseapp.core

import android.app.Application
import com.akilincarslan.baseapp.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication :Application() {

    override fun onCreate() {
        super.onCreate()
    }
}