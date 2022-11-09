package com.akilincarslan.baseapp.network.services.auth

import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.listener.ResponseListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class AuthRemoteDataSourceImpl @Inject constructor(
    private val auth: FirebaseAuth
) : AuthRemoteDataSource {
    override fun registerUser(user: User, listener: ResponseListener<AuthResult>) {
        auth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    listener.onSuccess(it.result)
                } else {
                    listener.onFailure(it.exception?.message)
                }
            }
    }
}