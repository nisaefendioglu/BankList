package com.nisaefendioglu.banklist.data.di

interface DataCallback<T> {
    fun onSuccess(data: T)
    fun onError(message: String)
}