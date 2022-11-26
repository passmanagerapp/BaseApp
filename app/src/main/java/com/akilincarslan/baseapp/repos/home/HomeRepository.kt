package com.akilincarslan.baseapp.repos.home

import androidx.lifecycle.MutableLiveData
import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.base.Resource
import com.google.firebase.auth.AuthResult

interface HomeRepository {
    fun getTopQuotes(result : MutableLiveData<Resource<List<Quote>>>)
    fun getDayOfQuotes(result : MutableLiveData<Resource<List<Quote>>>)
    fun getPeriodicPhilosophers(result : MutableLiveData<Resource<List<Quote>>>)
}