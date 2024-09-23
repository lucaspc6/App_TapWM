package com.example.memphisdeapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CorinthiansDao {
    @Query("SELECT * FROM seletimao")
    fun getAllTimes(): Flow<List<Corinthians>>

    @Query("SELECT * FROM seletimao WHERE id = :id")
    fun getTimeById(id: Int): Flow<Corinthians>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTime(corinthians: Corinthians)

    @Delete
    suspend fun deleteTime(corinthians: Corinthians)
}
