package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheByIdUseCase {
    suspend operator fun invoke(disheId: Int): Flow<List<com.prilepskiy.core.domain.model.DisheModel>>
}