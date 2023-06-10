package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.BasketModel
import kotlinx.coroutines.flow.Flow

interface GetAllSumUseCase {
    suspend operator fun invoke(): Flow<Int?>
}