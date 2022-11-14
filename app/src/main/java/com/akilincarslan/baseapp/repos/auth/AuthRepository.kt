package com.akilincarslan.baseapp.repos.auth

import androidx.lifecycle.MutableLiveData
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.base.Resource
import com.google.firebase.auth.AuthResult

interface AuthRepository {
    fun registerUser(user:User,result :MutableLiveData<Resource<AuthResult>>)
    fun sendResetPasswordLink(emailAddress:String,result :MutableLiveData<Resource<Void>>)
    fun signInUser(user:User,result :MutableLiveData<Resource<AuthResult>>)

}