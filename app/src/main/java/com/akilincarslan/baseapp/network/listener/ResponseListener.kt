package com.akilincarslan.baseapp.network.listener

interface ResponseListener<T> {
    fun onSuccess(response: T?)
    fun onFailure(errorMessage:String?)
}