package com.akilincarslan.baseapp.utils

import android.content.ActivityNotFoundException
import android.content.Intent
import com.akilincarslan.baseapp.core.BaseApplication
import com.akilincarslan.baseapp.utils.extension.ignoreNull
import com.akilincarslan.baseapp.utils.extension.startActivity


class Utils {

    companion object {
        fun openDefaultGmailApp() {
            val activity = BaseApplication.currentActivity() ?: return
            try {
                val intent = Intent(Intent.ACTION_MAIN)
                intent.addCategory(Intent.CATEGORY_APP_EMAIL)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                activity.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                DialogUtils.showErrorDialog(activity,e.message.ignoreNull())
            }
        }
    }
}