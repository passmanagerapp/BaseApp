package com.akilincarslan.baseapp.utils

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.addCallback
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.ui.dialog.LoadingDialog
import com.akilincarslan.baseapp.utils.helpers.LocalHelper
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    private val inputMethodManager by lazy {
        activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    }

    private var loadingDialog: LoadingDialog? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        findNavController().enableOnBackPressed(true)
    }

    val localHelper: LocalHelper
        get() = LocalHelper(requireContext())

    fun navigate(resId: Int, args: Bundle? = null, navOptions: NavOptions? = null) {
        findNavController().navigate(resId, args, navOptions)
    }

    fun navigate(direction: NavDirections, navOptions: NavOptions? = null) {
        findNavController().navigate(direction, navOptions)
    }

    fun navigateBack() {
        findNavController().popBackStack()
    }

    fun hideSoftKeyboard() {
        activity?.currentFocus?.let {
                inputMethodManager.hideSoftInputFromWindow(it.windowToken, 0)
            }
    }

    fun showProgressDialog() {
        loadingDialog?.let {
            if (it.isShowing)
                return
        }

        if (!requireActivity().isFinishing)
            loadingDialog = LoadingDialog.showDialog(requireContext())
    }

    fun hideProgressDialog() {
        loadingDialog?.let {
            if (!requireActivity().isFinishing && it.isShowing)
                it.dismiss()
        }
    }

    fun showSnackbar(message:String,block :() -> Unit) {
        Snackbar.make(requireView(),message,Snackbar.LENGTH_LONG)
            .setBackgroundTint(ContextCompat.getColor(requireContext(),R.color.dark_gray))
            .setTextColor(ContextCompat.getColor(requireContext(),R.color.white))
            .setActionTextColor(ContextCompat.getColor(requireContext(),R.color.pink))
            .setAction(getString(R.string.open)) { block() }
            .show()
    }
}