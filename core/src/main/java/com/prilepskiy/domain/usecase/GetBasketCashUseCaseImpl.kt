package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetBasketCashUseCase
import com.prilepskiy.domain.model.BasketModel
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.BasketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetBasketCashUseCaseImpl(private val repo: BasketRepository): GetBasketCashUseCase {
    override suspend fun invoke(): Flow<List<BasketModel>> = withContext(Dispatchers.IO) {
        repo.getBasketCash().map {
            val result: MutableList<BasketModel> = mutableListOf()
            it.forEach {
                result.add(BasketModel.from(it))
            }
            result

        }

    }
}