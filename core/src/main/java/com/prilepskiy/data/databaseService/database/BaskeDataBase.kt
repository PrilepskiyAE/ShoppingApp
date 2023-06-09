package com.prilepskiy.data.databaseService.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.prilepskiy.data.databaseService.dao.BasketDao
import com.prilepskiy.data.databaseService.entity.BasketEntity


@Database(
    entities = [BasketEntity::class] ,
    version = 1,
    exportSchema = true
)
abstract class BasketDataBase: RoomDatabase() {
    abstract val basketDao: BasketDao
}