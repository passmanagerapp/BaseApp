package com.akilincarslan.baseapp.ui.auth.register

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import com.akilincarslan.baseapp.R
import com.akilincarslan.baseapp.databinding.FragmentRegisterBinding
import com.akilincarslan.baseapp.enums.Status
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.utils.BaseInjectionFragment
import com.akilincarslan.baseapp.utils.DialogUtils
import com.akilincarslan.baseapp.utils.extension.ignoreNull
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseInjectionFragment<FragmentRegisterBinding,RegisterViewModel>() {
    override fun getLayoutRes(): Int = R.layout.fragment_register
    override fun getViewModelClass(): Class<RegisterViewModel>  = RegisterViewModel::class.java

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding()
        initObservers()
    }


    private fun initBinding() = with(binding){
        checkEmptyFields(etName,tilName)
        checkEmptyFields(etEmail,tilEmail)
        checkEmptyFields(etPassword,tilPassword)
        checkEmptyFields(etConfirmPassword,tilConfirmPassword)
        btnRegister.setOnClickListener {
          if (isFieldEmpty(etName) || isFieldEmpty(etEmail) || isFieldEmpty(etPassword) || isFieldEmpty(etConfirmPassword))
            DialogUtils.showErrorDialog(requireContext(),getString(R.string.check_empty_fields))
          else if (!isEmailValid())
              tilEmail.error = getString(R.string.valid_email_address_error)
          else if (!isPasswordStrength())
              tilPassword.error = getString(R.string.password_length)
          else if (!isPasswordsEqual(etPassword,etConfirmPassword))
              tilConfirmPassword.error = getString(R.string.password_not_equal)
          else
            register(etEmail.text?.toString().ignoreNull(),etPassword.text?.toString().ignoreNull())
        }
    }


    private fun initObservers() {
        viewModel.registerResult.observe(viewLifecycleOwner) {
            when(it.status) {
                Status.SUCCESS -> {
                    hideProgressDialog()
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

    private fun isPasswordStrength() :Boolean {
        return binding.etPassword.text.toString().count() >= 6
    }

    private fun isEmailValid() : Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(binding.etEmail.text.toString()).matches()
    }

    private fun register(email: String, password: String) {
        hideSoftKeyboard()
        viewModel.registerUser(User(email,password))
    }



}