package com.example.paperdemo.common.model

import androidx.room.*
import com.example.paperdemo.home.model.HomeItem
import com.example.paperdemo.home.model.HomeDao

@Database(
    version = 1,
    exportSchema = true,
    entities = [HomeItem::class],
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun homeDao(): HomeDao
}

