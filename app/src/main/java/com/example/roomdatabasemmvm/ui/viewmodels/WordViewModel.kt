package com.example.roomdatabasemmvm.ui.viewmodels

import androidx.lifecycle.*
import com.example.roomdatabasemmvm.models.Word
import com.example.roomdatabasemmvm.repository.WordRepository

import kotlinx.coroutines.launch

class WordViewModel(private val repository: WordRepository) : ViewModel() {

    //esse metodo asLivedata() retorno o flow como livedata
    //o flow basicamente abstrai o livedata para a gente ter a funcao de reatividade.o livedata vai ter esse retorno observavel para nossa view atraves da viewmodel

    val allWords: LiveData<List<Word>> = repository.allWords.asLiveData()

   //nenhuma operaçao de insercao de banco de dados pode ser executado na main thread
    //toda viewmodel tem um escopo de coroutina propria
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }
}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}