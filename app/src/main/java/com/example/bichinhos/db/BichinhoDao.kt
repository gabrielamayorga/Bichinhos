/*
package com.example.bichinhos.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.bichinhos.model.Bichinho

@Dao
interface BichinhoDao {

    @Query("SELECT * FROM bichinhos")
    fun listarBichinhos() : LiveData<List<Bichinho>>

    @Insert
    suspend fun inserir(bichinho: Bichinho)

    @Update
    suspend fun atualizar(bichinho: Bichinho)

    @Query("DELETE FROM bichinhos WHERE id = (:id)")
    suspend fun  apagar(id : Int)

    @Query("DELETE FROM bichinhos")
    suspend fun apagarTodos()
}*/
