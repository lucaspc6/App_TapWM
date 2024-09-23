package com.example.memphisdeapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.memphisdeapp.data.CorinthiansRepository
import com.example.memphisdeapp.data.Corinthians
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class CorinthiansViewModel(private val repository: CorinthiansRepository) : ViewModel() {

    val timeList: Flow<List<Corinthians>> = repository.getAllTimes()

    fun getTimeById(id: Int): Flow<Corinthians> = repository.getTimeById(id)

    fun addOrUpdateSpider(id: Int? = null, tecnico: String, ataque: String, meio: String, defesa: String, ano: Int) {
        val time = Corinthians(id = id ?: 0, tecnico = tecnico, ataque = ataque, meio = meio, defesa = defesa, ano = ano)
        viewModelScope.launch {
            repository.insertTime(time)
        }
    }

    fun deleteSpider(time: Corinthians) {
        viewModelScope.launch {
            repository.deleteTime(time)
        }
    }
}
