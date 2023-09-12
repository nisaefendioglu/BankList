package com.nisaefendioglu.banklist.data.source

import com.nisaefendioglu.banklist.data.di.DataCallback
import com.nisaefendioglu.banklist.model.Bank

interface BankDataSource {
    fun getBankBranchList(callback: DataCallback<List<Bank>>)
    fun saveBankBranchList(bankBranchList: List<Bank>)
}