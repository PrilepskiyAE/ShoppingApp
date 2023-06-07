package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetDisheByCategoryUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.flow.Flow

class GetDisheByCategoryUseCaseImpl(private val repo: DisheRepository): GetDisheByCategoryUseCase {
    override suspend fun invoke(categoryName: String): Flow<List<DisheModel>> {
        TODO("Not yet implemented")
    }
}