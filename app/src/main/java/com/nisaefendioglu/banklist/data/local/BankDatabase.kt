package com.nisaefendioglu.banklist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nisaefendioglu.banklist.model.Bank

@Database(
    entities = [Bank::class],
    version = 1,
    exportSchema = false
)
abstract class BankDatabase : RoomDatabase() {
    abstract fun bankDao(): BankDao
}