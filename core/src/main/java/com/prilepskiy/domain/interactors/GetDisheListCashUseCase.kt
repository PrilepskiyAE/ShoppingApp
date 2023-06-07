package com.prilepskiy.domain.interactors

import com.prilepskiy.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheListCashUseCase {
    suspend operator fun invoke(): Flow<List<DisheModel>>
}