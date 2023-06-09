package com.prilepskiy.domain.repository

import com.prilepskiy.data.databaseService.entity.BasketEntity
import kotlinx.coroutines.flow.Flow

interface BasketRepository {
    suspend fun getBasketCash(): Flow<List<BasketEntity>>

    suspend fun updateBtCash(basket:BasketEntity,isPositive:Boolean)
}