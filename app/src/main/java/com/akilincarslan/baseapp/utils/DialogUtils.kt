package com.akilincarslan.baseapp.utils

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.akilincarslan.baseapp.databinding.DialogErrorBinding

class DialogUtils {

    companion object {

        fun showErrorDialog(context:Context,message:String) {
            val builder = AlertDialog.Builder(context)
            val binding = DialogErrorBinding.inflate(LayoutInflater.from(context))
            binding.tvMessage.text = message
            builder.setView(binding.root)
            builder.create().show()
        }
    }
}