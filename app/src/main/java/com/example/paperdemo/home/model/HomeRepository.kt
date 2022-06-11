package com.example.paperdemo.home.model

import kotlinx.coroutines.flow.Flow

interface HomeRepository {

    suspend fun insert(homeItem: HomeItem)

    suspend fun delete(id: String)

    fun observeAll(): Flow<List<HomeItem>>
}