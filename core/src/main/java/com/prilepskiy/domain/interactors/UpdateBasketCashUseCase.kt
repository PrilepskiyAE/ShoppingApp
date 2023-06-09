package com.prilepskiy.domain.interactors

import com.prilepskiy.domain.model.BasketModel
import kotlinx.coroutines.flow.Flow

interface UpdateBasketCashUseCase {
    suspend operator fun invoke(basketModel: BasketModel)
}