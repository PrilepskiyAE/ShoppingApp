package com.prilepskiy.domain.interactors

import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.domain.model.DisheModel

interface GetDisheListNetworkUseCase {
    suspend operator fun invoke(): ActionResult<List<DisheModel>>
}