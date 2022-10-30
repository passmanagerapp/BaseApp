package com.akilincarslan.baseapp.ui.auth.main

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentAuthBinding
import com.akilincarslan.baseapp.databinding.FragmentRegisterBinding
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment : BaseInjectionFragment<FragmentAuthBinding,AuthViewModel>() {
    override fun getLayoutRes(): Int = R.layout.fragment_auth

    override fun getViewModelClass(): Class<AuthViewModel>  = AuthViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
    }

    private fun initBinding() = with(binding) {
        btnRegister.setOnClickListener { navigate(R.id.action_authFragment_to_registerFragment) }
    }
}