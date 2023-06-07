package com.prilepskiy.data.databaseService.dao

import androidx.room.Dao
import com.prilepskiy.data.databaseService.entity.CategoryEntity
import com.prilepskiy.data.databaseService.entity.DisheEntity

@Dao
abstract class DisheDao: BaseDao<DisheEntity>() {
}