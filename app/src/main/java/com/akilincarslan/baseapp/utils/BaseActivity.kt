package com.akilincarslan.baseapp.utils

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.akilincarslan.baseapp.ui.dialog.LoadingDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseActivity : AppCompatActivity() {

    private val inputMethodManager by lazy {
        getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    private var loadingDialog :LoadingDialog ? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showProgressDialog() {
        loadingDialog?.let {
            if (it.isShowing)
                return
        }

        if (!isFinishing)
            loadingDialog = LoadingDialog.showDialog(this)
    }

    fun hideProgressDialog() {
        loadingDialog?.let {
            if (!isFinishing && it.isShowing)
                it.dismiss()
        }
    }

    fun hideSoftKeyboard() {
        currentFocus?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken,0)
        }
    }

}