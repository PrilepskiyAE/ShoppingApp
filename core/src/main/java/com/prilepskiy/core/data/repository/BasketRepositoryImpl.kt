package com.prilepskiy.core.data.repository


import com.prilepskiy.core.data.databaseService.database.BasketDataBase
import com.prilepskiy.core.data.databaseService.entity.BasketEntity
import com.prilepskiy.core.domain.repository.BasketRepository
import kotlinx.coroutines.flow.Flow


class BasketRepositoryImpl(private val db: BasketDataBase) :
    BasketRepository {
    override suspend fun getBasketCash(): Flow<List<BasketEntity>> {
        return db.basketDao.getBasket()
    }

    override suspend fun deleteBtCash(basket: BasketEntity) {
        db.basketDao.delete(basket)
    }


    override suspend fun updateBtCash(basket: BasketEntity) {
       db.basketDao.insert(basket)
    }

    override suspend fun searchBtCash(basket: BasketEntity): Flow<BasketEntity?> {
     return   db.basketDao.searhBasket(basket.id)
    }
}