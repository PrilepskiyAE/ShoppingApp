package com.prilepskiy.domain.usecase

import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.domain.interactors.GetDisheListNetworkUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.DisheRepository

class GetDisheListNetworkUseCaseImpl(private val repo: DisheRepository): GetDisheListNetworkUseCase {
    override suspend fun invoke(): ActionResult<DisheModel> {
        TODO("Not yet implemented")
    }
}