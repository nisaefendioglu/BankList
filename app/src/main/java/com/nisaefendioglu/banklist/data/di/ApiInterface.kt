package com.nisaefendioglu.banklist.data.di
import com.nisaefendioglu.banklist.model.Bank
import com.nisaefendioglu.banklist.utils.Constants
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET(Constants.END_POINT)
    fun getBankList(): Call<List<Bank>>
}
