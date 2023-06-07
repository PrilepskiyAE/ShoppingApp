package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetDisheByIdUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.flow.Flow

class GetDisheByIdUseCaseImpl(private val repo: DisheRepository): GetDisheByIdUseCase {
    override suspend fun invoke(disheId: Int): Flow<List<DisheModel>> {
        TODO("Not yet implemented")
    }
}