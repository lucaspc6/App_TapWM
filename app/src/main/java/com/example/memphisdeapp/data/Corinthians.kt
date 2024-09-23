package com.example.memphisdeapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "seletimao")
data class Corinthians(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val tecnico: String,
    val ataque: String,
    val meio: String,
    val defesa: String,
    val ano: Int
)
