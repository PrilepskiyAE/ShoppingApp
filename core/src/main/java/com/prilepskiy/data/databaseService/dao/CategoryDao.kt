package com.prilepskiy.data.databaseService.dao

import androidx.room.Dao
import com.prilepskiy.data.databaseService.entity.CategoryEntity

@Dao
abstract class CategoryDao: BaseDao<CategoryEntity>() {
}