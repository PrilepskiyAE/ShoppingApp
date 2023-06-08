package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetDisheByCategoryUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetDisheByCategoryUseCaseImpl(private val repo: DisheRepository): GetDisheByCategoryUseCase {
    override suspend operator fun invoke(categoryName: String): Flow<List<DisheModel>> = withContext(
        Dispatchers.IO){
        repo.getDisheByCategory(categoryName).map {
            val result: MutableList<DisheModel> = mutableListOf()
            it.forEach {
                result.add(DisheModel.from(it))
            }
            result

        }
    }
}