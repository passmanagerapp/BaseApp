package com.akilincarslan.baseapp.ui.auth.forgotpassword

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.base.Resource
import com.akilincarslan.baseapp.repos.auth.AuthRepository
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ForgotPasswordViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val resetPasswordResult = MutableLiveData<Resource<Void>>()

    fun sendResetPasswordLink(email: String) {
        repository.sendResetPasswordLink(email,resetPasswordResult)
    }
}