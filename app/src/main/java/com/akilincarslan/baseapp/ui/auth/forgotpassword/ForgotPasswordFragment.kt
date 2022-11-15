package com.akilincarslan.baseapp.ui.auth.forgotpassword

import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentForgotPasswordBinding
import com.akilincarslan.baseapp.enums.Status
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import com.akilincarslan.baseapp.utils.DialogUtils
import com.akilincarslan.baseapp.utils.Utils
import com.akilincarslan.baseapp.utils.extension.ignoreNull
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgotPasswordFragment : BaseInjectionFragment<FragmentForgotPasswordBinding,ForgotPasswordViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_forgot_password
    override fun getViewModelClass(): Class<ForgotPasswordViewModel> = ForgotPasswordViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        initObservers()
    }

    private fun initBinding() = with(binding) {
        ivBack.setOnClickListener { navigateBack() }
        etEmail.doOnTextChanged { text, start, before, count ->
            btnRegister.isClickable = count !=0
            tilEmail.isErrorEnabled = false
        }
        btnRegister.setOnClickListener {
            if (isEmailValid())
                viewModel.sendResetPasswordLink(etEmail.text.toString())
            else {
                tilEmail.isErrorEnabled = true
                tilEmail.error = getString(R.string.valid_email_address_error)
            }
        }
    }

    private fun isEmailValid() : Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()
    }

    private fun initObservers() {
        viewModel.resetPasswordResult.observe(viewLifecycleOwner) {
            hideSoftKeyboard()
            when(it.status) {
                Status.LOADING -> showProgressDialog()
                Status.SUCCESS -> {
                    hideProgressDialog()
                    showSnackbar(getString(R.string.reset_password_email_sent_message)) {
                        Utils.openDefaultGmailApp()
                    }
                    navigateBack()
                }
                Status.ERROR -> {
                    hideProgressDialog()
                    DialogUtils.showErrorDialog(requireContext(),it.errorMessage.ignoreNull())
                }
            }
        }
    }
}