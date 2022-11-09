package com.akilincarslan.baseapp.repos.auth

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.base.Resource
import com.akilincarslan.baseapp.network.listener.ResponseListener
import com.akilincarslan.baseapp.network.services.auth.AuthRemoteDataSource
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val remoteDataSource: AuthRemoteDataSource
) :AuthRepository{

    override fun registerUser(user: User, result: MutableLiveData<Resource<AuthResult>>) {
        result.value = Resource.loading()
        remoteDataSource.registerUser(user,object :ResponseListener<AuthResult> {
            override fun onSuccess(response: AuthResult) {
                result.value = Resource.success(response)
            }

            override fun onFailure(errorMessage: String?) {
                result.value = Resource.error(errorMessage)
            }
        })
    }
}