package com.prilepskiy.data.databaseService.database

import androidx.room.Database
import androidx.room.RoomDatabase

import com.prilepskiy.data.databaseService.dao.CategoryDao
import com.prilepskiy.data.databaseService.entity.CategoryEntity

@Database(
    entities = [CategoryEntity::class] ,
    version = 1,
    exportSchema = true
)
abstract class CategoryDataBase: RoomDatabase() {
    abstract val categoryDao: CategoryDao
}