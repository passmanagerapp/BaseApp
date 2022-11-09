package com.akilincarslan.baseapp.network.base

import com.akilincarslan.baseapp.enums.Status

class Resource<T> {
    var status :Status
    var data: T? = null
    var errorMessage:String?=null

    private constructor(status: Status,data:T?,message:String?) {
        this.status = status
        this.data = data
        this.errorMessage = message
    }

    companion object {
        fun <T> success(data: T?) :Resource<T> {
            return Resource(Status.SUCCESS,data,null)
        }

        fun <T> error(message:String?,data:T?=null) :Resource<T> {
            return Resource(Status.ERROR,data,message)
        }

        fun <T> loading() :Resource<T> {
            return Resource(Status.LOADING,null,null)
        }
    }
}