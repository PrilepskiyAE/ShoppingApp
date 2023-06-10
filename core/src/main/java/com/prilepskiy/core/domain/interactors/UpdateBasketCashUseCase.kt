package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.BasketModel
import com.prilepskiy.core.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface UpdateBasketCashUseCase {
    suspend operator fun invoke(basketModel: com.prilepskiy.core.domain.model.BasketModel)
}