package com.example.memphisdeapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.memphisdeapp.data.CorinthiansRepository

class CorinthiansViewModelFactory(private val repository: CorinthiansRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CorinthiansViewModel::class.java)) {
            return CorinthiansViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
