package com.akilincarslan.baseapp.utils

import android.content.ActivityNotFoundException
import android.content.Intent
import com.akilincarslan.baseapp.core.BaseApplication
import com.akilincarslan.baseapp.utils.extension.ignoreNull
import com.akilincarslan.baseapp.utils.extension.startActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


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

        private fun getSpecificDayAsDayAndMonth(index:Int) :String {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.DATE,index)
            val sdf = SimpleDateFormat("dd MMM",Locale.getDefault())
            return sdf.format(calendar.time)
        }

        fun getDayAsString(position: Int): String {
            var day = ""
            when(position) {
                0 -> day ="TODAY"
                1 -> day = "YESTERDAY"
                2 -> {day = Utils.getSpecificDayAsDayAndMonth(-2)}
            }
            return day
        }
    }
}