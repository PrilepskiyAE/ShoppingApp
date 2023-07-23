package com.prilepskiy.core.data.databaseService.dao

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.core.data.databaseService.entity.DisheEntity
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
    @Query("SELECT * FROM dishe_table WHERE tegs LIKE '%' || :tag || '%'")
    abstract fun getDisheByTags(tag:String): Flow<List<DisheEntity>>

    @Query("SELECT * FROM dishe_table WHERE name LIKE '%' || :query || '%'")
    abstract fun searchDisheByName(query:String): Flow<List<DisheEntity>>
}