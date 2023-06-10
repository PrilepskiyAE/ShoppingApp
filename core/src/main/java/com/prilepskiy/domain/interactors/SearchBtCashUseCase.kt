package com.prilepskiy.domain.interactors

import com.prilepskiy.domain.model.BasketModel
import kotlinx.coroutines.flow.Flow

interface SearchBtCashUseCase {
    suspend operator fun invoke(basketModel: BasketModel): Flow<BasketModel?>
}