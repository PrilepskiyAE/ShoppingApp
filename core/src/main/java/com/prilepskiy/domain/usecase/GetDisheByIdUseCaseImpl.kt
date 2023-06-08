package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetDisheByIdUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetDisheByIdUseCaseImpl(private val repo: DisheRepository): GetDisheByIdUseCase {
    override suspend operator fun invoke(disheId: Int): Flow<List<DisheModel>> = withContext(Dispatchers.IO){
        repo.getDisheById(disheId).map {
            val result: MutableList<DisheModel> = mutableListOf()
            it.forEach {
                result.add(DisheModel.from(it))
            }
            result

        }
    }
}