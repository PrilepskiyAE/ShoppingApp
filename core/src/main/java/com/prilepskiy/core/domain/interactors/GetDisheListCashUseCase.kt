package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheListCashUseCase {
    suspend operator fun invoke(): Flow<List<com.prilepskiy.core.domain.model.DisheModel>>
}