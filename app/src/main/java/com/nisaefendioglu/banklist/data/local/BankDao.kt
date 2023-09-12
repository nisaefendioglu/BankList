package com.nisaefendioglu.banklist.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nisaefendioglu.banklist.model.Bank

@Dao
interface BankDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(bankBranchList: List<Bank>)

    @Query("SELECT * FROM Bank")
    fun getAllBanks(): List<Bank>
}