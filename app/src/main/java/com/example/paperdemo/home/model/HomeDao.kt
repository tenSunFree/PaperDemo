package com.example.paperdemo.home.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HomeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(homeItem: HomeItem)

    @Query("SELECT * FROM home_model_table ORDER BY time DESC")
    fun getAllNotes(): Flow<List<HomeItem>>

    @Query("DELETE FROM home_model_table WHERE id = :id")
    suspend fun deleteNote(id: String)
}