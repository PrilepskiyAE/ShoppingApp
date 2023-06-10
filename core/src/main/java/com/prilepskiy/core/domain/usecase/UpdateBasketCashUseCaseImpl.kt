package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.data.databaseService.entity.BasketEntity
import com.prilepskiy.core.domain.interactors.UpdateBasketCashUseCase
import com.prilepskiy.core.domain.model.BasketModel
import com.prilepskiy.core.domain.repository.BasketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UpdateBasketCashUseCaseImpl(private val repo: BasketRepository) : UpdateBasketCashUseCase {
    override suspend fun invoke(basketModel: BasketModel)
       = withContext(Dispatchers.IO) {
       if (basketModel.colum==0){
            repo.deleteBtCash(BasketEntity.from(basketModel))
            }else{
               repo.updateBtCash(BasketEntity.from(basketModel))
            }
        }
}





