package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetDisheByNameUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetDisheByNameUseCaseImpl(private val repo: DisheRepository): GetDisheByNameUseCase {
    override suspend operator fun invoke(disheName: String): Flow<List<DisheModel>> = withContext(Dispatchers.IO){
        repo.getDisheByName(disheName).map {
            val result: MutableList<DisheModel> = mutableListOf()
            it.forEach {
                result.add(DisheModel.from(it))
            }
            result

        }
    }
}