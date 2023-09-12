package com.nisaefendioglu.banklist.data.di.qualifier

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BankBranchDataSourceLocal

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BankBranchDataSourceRemote
