package com.akilincarslan.baseapp.ui.dialog

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.akilincarslan.baseapp.R

class LoadingDialog : AlertDialog {
    constructor(context:Context) : super(context) {}
    constructor(context: Context,theme:Int) :super(context,theme) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_loading)
    }

    companion object {
        @JvmStatic
        fun showDialog(context: Context):LoadingDialog {
            val dialog = LoadingDialog(context,R.style.FullScreenDialog)
            dialog.setCancelable(false)
            dialog.show()
            return dialog
        }
    }
}