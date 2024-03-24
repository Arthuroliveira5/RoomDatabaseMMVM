package com.example.roomdatabasemmvm.aplication

import android.app.Application
import com.example.roomdatabasemmvm.database.WordRoomDatabase
import com.example.roomdatabasemmvm.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

//extende a classe Aplication do android
//
class WordsApplication : Application() {

    //inicar o banco de dados
    private val applicationScope = CoroutineScope(SupervisorJob())

    //toda vez que ela iniciar ira ter instancia unica de databse e repository

    val database by lazy { WordRoomDatabase.getDatabase(applicationScope,this) }
    val repository by lazy { WordRepository(database.wordDao()) }
}