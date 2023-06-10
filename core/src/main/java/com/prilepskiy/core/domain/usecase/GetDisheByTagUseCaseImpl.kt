package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetDisheByTagUseCase
import com.prilepskiy.core.domain.model.DisheModel
import com.prilepskiy.core.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext


class GetDisheByTagUseCaseImpl(private val repo: DisheRepository): GetDisheByTagUseCase {
    override suspend operator fun invoke(tagName: String): Flow<List<DisheModel>> = withContext(
        Dispatchers.IO){
        repo.getDisheByTags(tagName).map {
            val result: MutableList<DisheModel> = mutableListOf()
            it.forEach {
                result.add(DisheModel.from(it))
            }
            result

        }
    }
}