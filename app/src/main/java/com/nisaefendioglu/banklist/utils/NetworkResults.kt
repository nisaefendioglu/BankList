package com.nisaefendioglu.banklist.utils

sealed class NetworkResults<T> (
    val data : T? = null,
    val message : String? = null,
    val error: String? = null
){
    class SUCCESS<T>(data: T?) : NetworkResults<T>(data)
    class ERROR<T>(message: String, data: T? = null) : NetworkResults<T>(data, message)
    class LOADING<T> : NetworkResults<T>()
}