package com.prilepskiy.domain.interactors


import com.prilepskiy.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheByTagUseCase {
    suspend operator fun invoke(tagName: String): Flow<List<DisheModel>>
}