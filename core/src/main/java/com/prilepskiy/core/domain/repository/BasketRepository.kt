package com.prilepskiy.core.domain.repository

import com.prilepskiy.core.data.databaseService.entity.BasketEntity
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    suspend fun getBasketCash(): Flow<List<com.prilepskiy.core.data.databaseService.entity.BasketEntity>>
    suspend fun deleteBtCash(basket: com.prilepskiy.core.data.databaseService.entity.BasketEntity)
    suspend fun updateBtCash(basket: com.prilepskiy.core.data.databaseService.entity.BasketEntity)
    suspend fun searchBtCash(basket: com.prilepskiy.core.data.databaseService.entity.BasketEntity):Flow<com.prilepskiy.core.data.databaseService.entity.BasketEntity?>
}