package com.example.memphisdeapp.data

import android.content.Context
import androidx.room.Room

class AppContainer(context: Context) {
    private val database: CorinthiansDatabase by lazy {
        Room.databaseBuilder(context, CorinthiansDatabase::class.java, "db_timao").build()
    }

    val corinthiansRepository: CorinthiansRepository by lazy {
        CorinthiansRepository(database.corinthiansDao())
    }
}