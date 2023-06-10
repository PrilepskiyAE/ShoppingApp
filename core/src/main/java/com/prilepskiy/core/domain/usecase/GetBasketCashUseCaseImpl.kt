package com.prilepskiy.core.domain.usecase


import com.prilepskiy.core.domain.model.BasketModel
import com.prilepskiy.core.domain.repository.BasketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetBasketCashUseCaseImpl(private val repo: BasketRepository):
    com.prilepskiy.core.domain.interactors.GetBasketCashUseCase {
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