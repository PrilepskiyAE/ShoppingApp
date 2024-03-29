package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.BasketModel
import kotlinx.coroutines.flow.Flow

interface SearchBtCashUseCase {
    suspend operator fun invoke(basketModel: BasketModel): Flow<BasketModel?>
}