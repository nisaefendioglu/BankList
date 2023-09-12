package com.nisaefendioglu.banklist.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nisaefendioglu.banklist.data.di.DataCallback
import com.nisaefendioglu.banklist.model.Bank
import com.nisaefendioglu.banklist.repository.BankRepository
import com.nisaefendioglu.banklist.utils.NetworkResults
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BankViewModel @Inject constructor(
    private val bankBranchesRepository: BankRepository
) : ViewModel() {
    val bankList = MutableLiveData<NetworkResults<List<Bank>>>()
    fun getBankBranches() {
        bankList.value = NetworkResults.LOADING()
        bankBranchesRepository.getBankList(object : DataCallback<List<Bank>> {
            override fun onSuccess(data: List<Bank>) {
                bankList.value = NetworkResults.SUCCESS(data)
            }

            override fun onError(message: String) {
                bankList.value = NetworkResults.ERROR(message)
            }
        })
    }
}
