package com.prilepskiy.core.domain.usecase


import com.prilepskiy.core.domain.interactors.GetDisheListCashUseCase
import com.prilepskiy.core.domain.model.DisheModel
import com.prilepskiy.core.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetDisheListCashUseCaseImpl(private val repo: DisheRepository) :
    GetDisheListCashUseCase {
    override suspend operator fun invoke(): Flow<List<DisheModel>> = withContext(Dispatchers.IO) {

        repo.getDisheListCash().map {
            val result: MutableList<DisheModel> = mutableListOf()
            it.forEach {
                result.add(DisheModel.from(it))
            }
            result

        }

    }
}