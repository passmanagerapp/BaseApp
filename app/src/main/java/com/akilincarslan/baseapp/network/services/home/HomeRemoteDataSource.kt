package com.akilincarslan.baseapp.network.services.home

import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.listener.ResponseListener
import com.google.firebase.auth.AuthResult

interface HomeRemoteDataSource {
    fun getTopQuotes(listener:ResponseListener<List<Quote>>)
    fun getDayOfQuotes(listener:ResponseListener<List<Quote>>)
    fun getPeriodicPhilosophers(listener:ResponseListener<List<Quote>>)
}