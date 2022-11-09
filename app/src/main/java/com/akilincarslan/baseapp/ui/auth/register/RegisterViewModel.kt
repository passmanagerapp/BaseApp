package com.akilincarslan.baseapp.ui.auth.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.base.Resource
import com.akilincarslan.baseapp.repos.auth.AuthRepository
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    val repository: AuthRepository
) : ViewModel() {

    val registerResult = MutableLiveData<Resource<AuthResult>>()

    fun registerUser(user: User) {
        repository.registerUser(user,registerResult)
    }

}