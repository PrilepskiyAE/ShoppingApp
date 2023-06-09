package com.prilepskiy.domain.interactors

import com.prilepskiy.domain.model.BasketModel
import com.prilepskiy.domain.model.CategoryModel
import com.prilepskiy.domain.repository.BasketRepository
import kotlinx.coroutines.flow.Flow

interface GetBasketCashUseCase {
    suspend operator fun invoke(): Flow<List<BasketModel>>
}