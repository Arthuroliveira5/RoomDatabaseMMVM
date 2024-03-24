package com.example.roomdatabasemmvm.repository

import androidx.annotation.WorkerThread
import com.example.roomdatabasemmvm.daos.WordDao
import com.example.roomdatabasemmvm.models.Word

import kotlinx.coroutines.flow.Flow

class WordRepository(private val wordDao: WordDao) {



    val allWords: Flow<List<Word>> = wordDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
