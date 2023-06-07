package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetDisheByNameUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.flow.Flow

class GetDisheByNameUseCaseImpl(private val repo: DisheRepository): GetDisheByNameUseCase {
    override suspend fun invoke(disheName: String): Flow<List<DisheModel>> {
        TODO("Not yet implemented")
    }
}