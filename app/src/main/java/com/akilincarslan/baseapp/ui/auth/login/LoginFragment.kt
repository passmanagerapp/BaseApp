package com.akilincarslan.baseapp.ui.auth.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentLoginBinding
import com.akilincarslan.baseapp.enums.Status
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.ui.main.MainActivity
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import com.akilincarslan.baseapp.utils.DialogUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment :BaseInjectionFragment<FragmentLoginBinding,LoginViewModel>() {

    override fun getLayoutRes(): Int = R.layout.fragment_login

    override fun getViewModelClass(): Class<LoginViewModel> = LoginViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        initObservers()
    }

    private fun initBinding() = with(binding) {
        ivBack.setOnClickListener { navigateBack() }
        tvForgotPassword.setOnClickListener { navigate(R.id.action_loginFragment_to_forgotPasswordFragment) }
        btnLogin.setOnClickListener { loginUser() }
    }

    private fun loginUser() {
        if (isFieldEmpty(binding.etEmail) || isFieldEmpty(binding.etPassword))
            DialogUtils.showErrorDialog(requireContext(),getString(R.string.check_empty_fields))
        else if (!isEmailValid())
            binding.tilEmail.error = getString(R.string.valid_email_address_error)
        else
            viewModel.loginUser(User(binding.etEmail.text.toString(),binding.etPassword.text.toString()))
    }


    private fun isFieldEmpty(editText: EditText) :Boolean {
        return editText.text.toString().isEmpty()
    }

    private fun isEmailValid() : Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()
    }

    private fun initObservers() {
        viewModel.loginResult.observe(viewLifecycleOwner) {
            when(it.status) {
                Status.SUCCESS -> {
                    hideProgressDialog()
                    startActivity(Intent(requireContext(),MainActivity::class.java))
                }
                Status.LOADING -> {
                    showProgressDialog()
                }
                Status.ERROR -> {
                    hideProgressDialog()
                    DialogUtils.showErrorDialog(requireContext(),it.errorMessage ?: "")
                }
            }
        }
    }
}