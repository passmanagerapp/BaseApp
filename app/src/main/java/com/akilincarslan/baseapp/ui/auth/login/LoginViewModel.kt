package com.akilincarslan.baseapp.ui.auth.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.base.Resource
import com.akilincarslan.baseapp.repos.auth.AuthRepository
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
) : ViewModel() {

    val loginResult = MutableLiveData<Resource<AuthResult>>()

    fun loginUser(user: User) {
        repository.signInUser(user,loginResult)
    }

}