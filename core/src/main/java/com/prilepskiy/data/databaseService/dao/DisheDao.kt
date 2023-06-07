package com.prilepskiy.data.databaseService.dao

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.data.databaseService.entity.DisheEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class DisheDao: BaseDao<DisheEntity>() {

    @Query("SELECT * FROM dishe_table")
    abstract fun getDishe(): Flow<List<DisheEntity>>

    @Query("SELECT * FROM dishe_table WHERE name=:name")
    abstract fun getDisheByName(name:String): Flow<List<DisheEntity>>

    @Query("SELECT * FROM dishe_table WHERE id=:id")
    abstract fun getDisheById(id:Int): Flow<List<DisheEntity>>

    //todo
    @Query("SELECT * FROM dishe_table WHERE tegs LIKE '%' || :category || '%'")
    abstract fun getDisheByCategory(category:String): Flow<List<DisheEntity>>
}