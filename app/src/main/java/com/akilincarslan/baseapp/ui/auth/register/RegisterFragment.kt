package com.akilincarslan.baseapp.ui.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentRegisterBinding
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseInjectionFragment<FragmentRegisterBinding,RegisterViewModel>() {
    override fun getLayoutRes(): Int = R.layout.fragment_register
    override fun getViewModelClass(): Class<RegisterViewModel>  = RegisterViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
    }

    private fun initBinding() = with(binding){

        btnRegister.setOnClickListener {
            checkEmptyFields(etName)
            checkEmptyFields(etEmail)
            checkEmptyFields(etPassword)
            checkEmptyFields(etConfirmPassword)
        }
    }

    private fun checkEmptyFields(editText: EditText) :Pair<Boolean,String> {
        var isEmpty = true
        var text =""
        editText.doAfterTextChanged { input->
            input?.let {
                isEmpty = it.isEmpty()
                text = it.toString()
            }
        }
        if (isEmpty)
            editText.error = "You must enter ${editText.hint.toString().lowercase()}"
        return Pair(isEmpty,text)
    }

}