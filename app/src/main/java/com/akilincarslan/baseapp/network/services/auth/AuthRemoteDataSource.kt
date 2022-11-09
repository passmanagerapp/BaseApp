package com.akilincarslan.baseapp.network.services.auth

import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.listener.ResponseListener
import com.google.firebase.auth.AuthResult

interface AuthRemoteDataSource {
    fun registerUser(user: User, listener:ResponseListener<AuthResult>)
}