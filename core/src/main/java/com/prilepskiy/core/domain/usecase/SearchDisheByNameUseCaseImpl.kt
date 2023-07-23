package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.SearchDisheByNameUseCase
import com.prilepskiy.core.domain.model.DisheModel
import com.prilepskiy.core.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class SearchDisheByNameUseCaseImpl(private val repo: DisheRepository): SearchDisheByNameUseCase {
    override suspend fun invoke(query: String): Flow<List<DisheModel>?> = withContext(Dispatchers.IO){
        repo.searchDisheByName(query).map {
            val result: MutableList<DisheModel> = mutableListOf()
            it.forEach {
                result.add(DisheModel.from(it))
            }
            result

        }
    }
}