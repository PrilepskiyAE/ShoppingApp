package com.prilepskiy.core.domain.interactors


import com.prilepskiy.core.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheByTagUseCase {
    suspend operator fun invoke(tagName: String): Flow<List<com.prilepskiy.core.domain.model.DisheModel>>
}