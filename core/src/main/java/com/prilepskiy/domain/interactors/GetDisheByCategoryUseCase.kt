package com.prilepskiy.domain.interactors


import com.prilepskiy.domain.model.DisheModel
import kotlinx.coroutines.flow.Flow

interface GetDisheByCategoryUseCase {
    suspend operator fun invoke(categoryName: String): Flow<List<DisheModel>>
}