package com.example.memphisdeapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Corinthians::class], version = 1, exportSchema = false)
abstract class CorinthiansDatabase : RoomDatabase() {
    abstract fun corinthiansDao(): CorinthiansDao
}
