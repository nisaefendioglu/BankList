package com.nisaefendioglu.banklist.data.source

import com.nisaefendioglu.banklist.data.di.DataCallback
import com.nisaefendioglu.banklist.data.di.ApiInterface
import com.nisaefendioglu.banklist.data.di.qualifier.BankBranchDataSourceLocal
import com.nisaefendioglu.banklist.model.Bank
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class BankRemoteDataSource
@Inject constructor(
    private val apiService: ApiInterface,
    @BankBranchDataSourceLocal private val bankBranchLocalDataSource: BankDataSource
): BankDataSource {

    override fun getBankBranchList(callback: DataCallback<List<Bank>>) {

        val call: Call<List<Bank>> = apiService.getBankList()
        call.enqueue(object : Callback<List<Bank>> {
            override fun onResponse(
                call: Call<List<Bank>>,
                response: Response<List<Bank>>
            ) {
                if (response.isSuccessful) {
                    val bankBranchList = response.body() ?: emptyList()
                    bankBranchLocalDataSource.saveBankBranchList(bankBranchList)
                    callback.onSuccess(data = bankBranchList)
                } else {
                    callback.onError(message = response.message())
                }
            }

            override fun onFailure(call: Call<List<Bank>>, t: Throwable) {
                callback.onError(message = t.message ?: "")
            }
        })
    }

    override fun saveBankBranchList(bankBranchList: List<Bank>) {}
}