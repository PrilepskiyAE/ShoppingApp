package com.prilepskiy.domain.interactors

import com.prilepskiy.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheByNameUseCase {
    suspend operator fun invoke(disheName: String): Flow<List<DisheModel>>
}