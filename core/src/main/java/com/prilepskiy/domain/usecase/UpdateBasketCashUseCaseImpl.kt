package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.UpdateBasketCashUseCase
import com.prilepskiy.domain.model.BasketModel
import com.prilepskiy.domain.repository.BasketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateBasketCashUseCaseImpl(repo: BasketRepository): UpdateBasketCashUseCase {
    override suspend fun invoke(basketModel: BasketModel) = withContext(Dispatchers.IO){
        TODO("Not yet implemented")
    }
}