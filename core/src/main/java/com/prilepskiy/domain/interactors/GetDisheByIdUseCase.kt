package com.prilepskiy.domain.interactors

import com.prilepskiy.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheByIdUseCase {
    suspend operator fun invoke(disheId: Int): Flow<List<DisheModel>>
}