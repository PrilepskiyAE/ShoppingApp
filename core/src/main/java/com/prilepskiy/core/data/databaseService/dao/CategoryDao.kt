package com.prilepskiy.core.data.databaseService.dao

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CategoryDao:BaseDao<CategoryEntity>() {

    @Query("SELECT * FROM category_table")
    abstract fun getCategory(): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM category_table WHERE name=:name")
    abstract fun getCategoryByName(name:String): Flow<List<CategoryEntity>>

    @Query("SELECT * FROM category_table WHERE id=:id")
    abstract fun getCategoryById(id:Int): Flow<List<CategoryEntity>>
}