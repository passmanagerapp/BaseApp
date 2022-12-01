package com.akilincarslan.baseapp.network.services.home

import com.akilincarslan.baseapp.constants.FirebaseConstants
import com.akilincarslan.baseapp.models.Quote
import com.akilincarslan.baseapp.models.User
import com.akilincarslan.baseapp.network.listener.ResponseListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import okhttp3.internal.filterList
import javax.inject.Inject

class HomeRemoteDataSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore
) : HomeRemoteDataSource {

    override fun getTopQuotes(listener: ResponseListener<List<Quote>>) {
        firestore.collection(FirebaseConstants.QUOTES)
            .whereEqualTo("isTop", true)
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val itemList = arrayListOf<Quote>()
                    for (document in it.result) {
                        val singleItem = document.toObject(Quote::class.java)
                        itemList.add(singleItem)
                    }
                    listener.onSuccess(itemList)
                } else {
                    listener.onFailure(it.exception?.message)
                }
            }
    }

    override fun getDayOfQuotes(listener: ResponseListener<List<Quote>>) {
        firestore.collection(FirebaseConstants.QUOTES)
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val itemList = arrayListOf<Quote>()
                    for (document in it.result) {
                        val singleItem = document.toObject(Quote::class.java)
                        itemList.add(singleItem)
                    }
                    listener.onSuccess(itemList.shuffled().take(3))
                } else {
                    listener.onFailure(it.exception?.message)
                }
            }
    }

    override fun getPeriodicPhilosophers(listener: ResponseListener<List<Quote>>) {
        firestore.collection(FirebaseConstants.QUOTES)
            .get()
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val itemList = arrayListOf<Quote>()
                    for (document in it.result) {
                        val singleItem = document.toObject(Quote::class.java)
                        itemList.add(singleItem)
                    }
                    listener.onSuccess(itemList.sortedBy { it.period }.distinctBy { it.period })
                } else {
                    listener.onFailure(it.exception?.message)
                }
            }
    }
}