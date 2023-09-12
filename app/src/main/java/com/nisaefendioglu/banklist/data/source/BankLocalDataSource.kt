package com.nisaefendioglu.banklist.data.source

import com.nisaefendioglu.banklist.data.di.DataCallback
import com.nisaefendioglu.banklist.data.local.BankDao
import com.nisaefendioglu.banklist.model.Bank
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(DelicateCoroutinesApi::class)
class BankLocalDataSource
@Inject constructor(
    private val bankDao: BankDao
): BankDataSource {
    override fun getBankBranchList(callback: DataCallback<List<Bank>>){
        GlobalScope.launch {
            val branchList =  bankDao.getAllBanks()
            if(branchList.isNotEmpty()) {
                callback.onSuccess(branchList)
            } else {
                callback.onError("Data not found")
            }
        }
    }

    override fun saveBankBranchList(bankBranchList: List<Bank>) {
        GlobalScope.launch {
            bankDao.save(bankBranchList)
        }
    }
}