package com.example.memphisdeapp.data

import kotlinx.coroutines.flow.Flow

open class CorinthiansRepository(private val corinthiansDao: CorinthiansDao) {
    fun getAllTimes(): Flow<List<Corinthians>> = corinthiansDao.getAllTimes()

    fun getTimeById(id: Int): Flow<Corinthians> = corinthiansDao.getTimeById(id)

    suspend fun insertTime(corinthians: Corinthians) = corinthiansDao.insertTime(corinthians)

    suspend fun deleteTime(corinthians: Corinthians) = corinthiansDao.deleteTime(corinthians)
}
