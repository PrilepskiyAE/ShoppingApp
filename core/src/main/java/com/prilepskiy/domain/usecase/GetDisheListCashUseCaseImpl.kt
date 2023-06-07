package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetDisheListCashUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.flow.Flow

class GetDisheListCashUseCaseImpl(private val repo: DisheRepository): GetDisheListCashUseCase {
    override suspend fun invoke(): Flow<List<DisheModel>> {
        TODO("Not yet implemented")
    }
}