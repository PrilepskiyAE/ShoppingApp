package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetAllSumUseCase
import com.prilepskiy.core.domain.repository.BasketRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class GetAllSumUseCaseImpl(private val repo: BasketRepository): GetAllSumUseCase {
    override suspend fun invoke(): Flow<Int?> = withContext(Dispatchers.IO){
        repo.getAllSumm()
    }
}