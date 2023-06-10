package com.prilepskiy.domain.usecase

import android.util.Log
import com.prilepskiy.data.databaseService.entity.BasketEntity
import com.prilepskiy.domain.interactors.UpdateBasketCashUseCase
import com.prilepskiy.domain.model.BasketModel
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.model.TagModel
import com.prilepskiy.domain.repository.BasketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.dropWhile
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.takeWhile
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





