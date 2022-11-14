package com.akilincarslan.baseapp.ui.auth.login

import android.os.Bundle
import android.view.View
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentLoginBinding
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
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
    }

    private fun initObservers() {

    }
}