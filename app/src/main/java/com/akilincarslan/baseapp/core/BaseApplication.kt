package com.akilincarslan.baseapp.core

import android.app.Activity
import android.app.Application
import com.akilincarslan.baseapp.utils.helpers.BaseActivityLifecycleCallbacks
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {

    private val baseActivityLifecycleCallbacks = BaseActivityLifecycleCallbacks()
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(baseActivityLifecycleCallbacks)
    }
    init {
        instance = this
    }

    companion object {
        private var instance: BaseApplication? = null

        fun currentActivity() : Activity? {
            return instance?.baseActivityLifecycleCallbacks?.currentActivity
        }
    }
}