package com.nisaefendioglu.banklist.data.di.module

import com.nisaefendioglu.banklist.data.di.qualifier.BankBranchDataSourceLocal
import com.nisaefendioglu.banklist.data.di.qualifier.BankBranchDataSourceRemote
import com.nisaefendioglu.banklist.data.source.BankDataSource
import com.nisaefendioglu.banklist.data.source.BankLocalDataSource
import com.nisaefendioglu.banklist.data.source.BankRemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Suppress("unused")
@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @BankBranchDataSourceLocal
    abstract fun bindBankBranchLocalDataSource(bankBranchLocalDataSource: BankLocalDataSource): BankDataSource

    @Binds
    @BankBranchDataSourceRemote
    abstract fun bindBankBranchRemoteDataSource(bankBranchRemoteDataSource: BankRemoteDataSource): BankDataSource
}