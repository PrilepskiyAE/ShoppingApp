package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheByNameUseCase {
    suspend operator fun invoke(disheName: String): Flow<List<com.prilepskiy.core.domain.model.DisheModel>>
}