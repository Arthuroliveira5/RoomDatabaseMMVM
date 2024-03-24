package com.example.roomdatabasemmvm.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


//Model= REPRESENTACAO DO CODIGO DA TABELA  NO BANCO DE DADOS
//DAO= ACESSO AO DADO
//REPOSITORY=ABSTRAI A FONTE DE DADOS(BANCO DE DADOS) PARA A VIEWMODEL
//VIEWMODEL=UTILIZA O REPOSITORIO PARA OBSERVA AS MUDANCAS NO BANCO DE DADOS (FONTE DE DADOS)

@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey @ColumnInfo(name="word") val word: String
)