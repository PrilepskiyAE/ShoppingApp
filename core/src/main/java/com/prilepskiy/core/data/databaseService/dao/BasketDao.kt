package com.prilepskiy.core.data.databaseService.dao

import androidx.room.Dao
import androidx.room.Query
import com.prilepskiy.core.data.databaseService.entity.BasketEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class BasketDao: BaseDao<BasketEntity>() {
    @Query("SELECT * FROM basket_table")
    abstract fun getBasket(): Flow<List<BasketEntity>>

    @Query("SELECT * FROM basket_table WHERE :id=id")
    abstract fun searhBasket(id:Int): Flow<BasketEntity?>
}