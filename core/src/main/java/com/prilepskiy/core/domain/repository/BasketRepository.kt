package com.prilepskiy.core.domain.repository

import com.prilepskiy.core.data.databaseService.entity.BasketEntity
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    suspend fun getBasketCash(): Flow<List<BasketEntity>>
    suspend fun deleteBtCash(basket: BasketEntity)
    suspend fun updateBtCash(basket: BasketEntity)
    suspend fun searchBtCash(basket: BasketEntity):Flow<BasketEntity?>
    suspend fun getAllSumm():Flow<Int?>
}