package com.prilepskiy.data.databaseService.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prilepskiy.data.databaseService.dao.DisheDao
import com.prilepskiy.data.databaseService.entity.DisheEntity

@Database(
    entities = [DisheEntity::class] ,
    version = 1,
    exportSchema = true
)
abstract class DisheDataBase: RoomDatabase() {
    abstract val disheDao: DisheDao
}