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
import com.akilincarslan.baseapp.utils.DialogUtils
import com.google.android.material.textfield.TextInputLayout
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
        checkEmptyFields(etName,tilName)
        checkEmptyFields(etEmail,tilEmail)
        checkEmptyFields(etPassword,tilPassword)
        checkEmptyFields(etConfirmPassword,tilConfirmPassword)
        btnRegister.setOnClickListener {
          if (isFieldEmpty(etName) || isFieldEmpty(etEmail) || isFieldEmpty(etPassword) || isFieldEmpty(etConfirmPassword))
            DialogUtils.showErrorDialog(requireContext(),"Please check empty fields")
          else if (!isPasswordsEqual(etPassword,etConfirmPassword))
              // todo snackbar or alert dialog
          else
            register()
        }
    }

    private fun checkEmptyFields(editText: EditText,inputLayout: TextInputLayout) {
        editText.doOnTextChanged { text, start, before, count ->
            inputLayout.isErrorEnabled = text.isNullOrEmpty()
            inputLayout.error = if (text.isNullOrEmpty()) getString(R.string.empty_field_error_message, inputLayout.hint.toString().lowercase()) else null
        }
    }

    private fun isFieldEmpty(editText: EditText) :Boolean {
        return editText.text.toString().isEmpty()
    }

    private fun isPasswordsEqual(editText1: EditText,editText2: EditText) :Boolean {
        return editText1.text.toString().equals(editText2.text.toString())
    }

    private fun register() {

    }

}