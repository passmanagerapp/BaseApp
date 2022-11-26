package com.akilincarslan.baseapp.repos.home

import androidx.lifecycle.MutableLiveData
import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.network.base.Resource
import com.akilincarslan.baseapp.network.listener.ResponseListener
import com.akilincarslan.baseapp.network.services.home.HomeRemoteDataSource
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(
    private val remoteDataSource: HomeRemoteDataSource
) :HomeRepository {

    override fun getTopQuotes(result: MutableLiveData<Resource<List<Quote>>>) {
        result.value = Resource.loading()
        remoteDataSource.getTopQuotes(object : ResponseListener<List<Quote>> {
            override fun onSuccess(response: List<Quote>?) {
                result.value = Resource.success(response)
            }

            override fun onFailure(errorMessage: String?) {
                result.value = Resource.error(errorMessage)
            }
        })
    }

    override fun getDayOfQuotes(result: MutableLiveData<Resource<List<Quote>>>) {
        result.value = Resource.loading()
        remoteDataSource.getDayOfQuotes(object : ResponseListener<List<Quote>> {
            override fun onSuccess(response: List<Quote>?) {
                result.value = Resource.success(response)
            }

            override fun onFailure(errorMessage: String?) {
                result.value = Resource.error(errorMessage)
            }
        })
    }

    override fun getPeriodicPhilosophers(result: MutableLiveData<Resource<List<Quote>>>) {
        result.value = Resource.loading()
        remoteDataSource.getPeriodicPhilosophers(object : ResponseListener<List<Quote>> {
            override fun onSuccess(response: List<Quote>?) {
                result.value = Resource.success(response)
            }

            override fun onFailure(errorMessage: String?) {
                result.value = Resource.error(errorMessage)
            }
        })
    }
}