package com.nisaefendioglu.banklist.repository

import android.content.Context
import com.nisaefendioglu.banklist.data.di.DataCallback
import com.nisaefendioglu.banklist.data.di.qualifier.BankBranchDataSourceLocal
import com.nisaefendioglu.banklist.data.di.qualifier.BankBranchDataSourceRemote
import com.nisaefendioglu.banklist.data.source.BankDataSource
import com.nisaefendioglu.banklist.model.Bank
import com.nisaefendioglu.banklist.utils.isNetworkConnected
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class BankRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    @BankBranchDataSourceLocal private val localDataSource: BankDataSource,
    @BankBranchDataSourceRemote private val remoteDataSource: BankDataSource
) {
    fun getBankList(callback: DataCallback<List<Bank>>) {
        val dataSource = if (context.isNetworkConnected) remoteDataSource else localDataSource
        dataSource.getBankBranchList(callback)
    }
}
