package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.data.databaseService.entity.BasketEntity
import com.prilepskiy.core.domain.interactors.SearchBtCashUseCase
import com.prilepskiy.core.domain.model.BasketModel
import com.prilepskiy.core.domain.repository.BasketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class SearchBtCashUseCaseImpl(private val repo: BasketRepository): SearchBtCashUseCase {
    override suspend fun invoke(basketModel:BasketModel): Flow<BasketModel?> = withContext(Dispatchers.IO){
        repo.searchBtCash(BasketEntity.from(basketModel)).map {
            if (it != null) {
                BasketModel.from(it)
            }else null
        }
    }

}