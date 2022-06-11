package com.example.paperdemo.common.di

import android.content.Context
import androidx.room.Room
import com.example.paperdemo.common.model.AppDatabase
import com.example.paperdemo.common.model.MIGRATION_1_2
import com.example.paperdemo.common.model.MIGRATION_2_3
import com.example.paperdemo.home.model.HomeDao
import com.example.paperdemo.home.model.HomeRepository
import com.example.paperdemo.home.model.HomeRepositoryImpl

fun getDatabase(context: Context): AppDatabase {
    return synchronized(context) {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database_paper_demo"
        ).addMigrations(MIGRATION_1_2, MIGRATION_2_3).build()
    }
}

fun getHomeDao(database: AppDatabase) = database.homeDao()

fun getHomeRepository(
    dao: HomeDao
): HomeRepository = HomeRepositoryImpl(dao)