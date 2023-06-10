package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.data.utils.ActionResult
import com.prilepskiy.core.domain.model.DisheModel


interface GetDisheListNetworkUseCase {
    suspend operator fun invoke(): ActionResult<List<DisheModel>>
}