package com.prilepskiy.domain.interactors

import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.domain.model.CategoryModel

interface GetCategoryNetworkUseCase {
    suspend operator fun invoke(): ActionResult<CategoryModel>
}