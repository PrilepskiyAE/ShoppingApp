package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.domain.model.BasketModel
import com.prilepskiy.core.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface SearchDisheByNameUseCase {
    suspend operator fun invoke(query:String): Flow<List<DisheModel>?>
}