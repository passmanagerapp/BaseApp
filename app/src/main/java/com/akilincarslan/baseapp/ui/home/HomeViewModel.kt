package com.akilincarslan.baseapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.base.Resource
import com.akilincarslan.baseapp.repos.home.HomeRepository
import com.google.firebase.auth.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val topQuotesResult = MutableLiveData<Resource<List<Quote>>>()
    val dayOfQuotesResult = MutableLiveData<Resource<List<Quote>>>()
    val periodicResult = MutableLiveData<Resource<List<Quote>>>()

    init {
        getTopQuoteList()
        getDayOfQuoteList()
        getPeriodicPhilosophers()
    }

    private fun getTopQuoteList() {
        repository.getTopQuotes(topQuotesResult)
    }

    private fun getDayOfQuoteList() {
        repository.getDayOfQuotes(dayOfQuotesResult)
    }

    private fun getPeriodicPhilosophers() {
        repository.getPeriodicPhilosophers(periodicResult)
    }

}