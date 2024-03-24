package com.example.roomdatabasemmvm.daos
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdatabasemmvm.models.Word
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {
    //Flow é um tipo de fluxo reativo usado no Kotlin para retornar um fluxo de valores ao longo do tempo. É semelhante ao Observable no RxJava ou LiveData no Android Jetpack.
    //Flow: É projetado para ser usado em conjunto com Kotlin Coroutines.


    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word : Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

}