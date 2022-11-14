package com.akilincarslan.baseapp.network.services.auth

import androidx.lifecycle.MutableLiveData
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.base.Resource
import com.akilincarslan.baseapp.network.listener.ResponseListener
import com.google.firebase.auth.AuthResult

interface AuthRemoteDataSource {
    fun registerUser(user: User, listener:ResponseListener<AuthResult>)
    fun sendResetPasswordLink(emailAddress:String, listener:ResponseListener<Void>)
    fun signInUser(user: User, listener:ResponseListener<AuthResult>)
}