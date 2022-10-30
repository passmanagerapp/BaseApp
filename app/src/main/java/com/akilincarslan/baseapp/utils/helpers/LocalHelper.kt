package com.akilincarslan.baseapp.utils.helpers

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import com.akilincarslan.baseapp.R
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class LocalHelper @Inject constructor(val context: Context) {

    private fun getSharedPrefInstance(): SharedPreferences {
        val sharedPreferences: SharedPreferences = (context as Activity).getSharedPreferences(
            context.getString(R.string.preference_file_key),
            Context.MODE_PRIVATE
        )
        return sharedPreferences
    }

    private fun getSharedPrefEditInstance(): SharedPreferences.Editor {
        return getSharedPrefInstance().edit()
    }

    /*Boolean*/
    fun putPrefBoolean(name: String, value: Boolean) {
        with(getSharedPrefEditInstance()) {
            putBoolean(name, value)
            apply()
        }
    }

    fun getPrefBoolean(name: String, defaultValue: Boolean): Boolean =
        getSharedPrefInstance().getBoolean(name, defaultValue)


    /*String*/
    fun putPrefString(name: String, value: String) {
        with(getSharedPrefEditInstance()) {
            putString(name, value)
            apply()
        }
    }

    fun getPrefString(name: String, defaultValue: String): String =
        getSharedPrefInstance().getString(name, defaultValue) ?: ""


    /*Int*/
    fun putPrefInt(name: String, value: Int) {
        with(getSharedPrefEditInstance()) {
            putInt(name, value)
            apply()
        }
    }

    fun getPrefInt(name: String, defaultValue: Int): Int =
        getSharedPrefInstance().getInt(name, defaultValue)

}