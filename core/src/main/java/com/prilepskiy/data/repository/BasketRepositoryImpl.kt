package com.prilepskiy.data.repository

import android.util.Log
import com.prilepskiy.data.databaseService.database.BasketDataBase
import com.prilepskiy.data.databaseService.entity.BasketEntity
import com.prilepskiy.domain.model.TagModel
import com.prilepskiy.domain.repository.BasketRepository

import kotlinx.coroutines.flow.Flow


class BasketRepositoryImpl(private val db: BasketDataBase) : BasketRepository {
    override suspend fun getBasketCash(): Flow<List<BasketEntity>> {
        return db.basketDao.getBasket()
    }

    override suspend fun deleteBtCash(basket: BasketEntity) {
        deleteBtCash(basket)
    }


    override suspend fun updateBtCash(basket: BasketEntity) {
       db.basketDao.insert(basket)
    }

    override suspend fun searchBtCash(basket: BasketEntity): Flow<BasketEntity?> {
     return   db.basketDao.searhBasket(basket.id)
    }
}