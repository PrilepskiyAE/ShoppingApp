package com.prilepskiy.core.domain.interactors

import com.prilepskiy.core.data.utils.ActionResult
import com.prilepskiy.core.domain.model.CategoryModel


interface GetCategoryNetworkUseCase {
    suspend operator fun invoke(): ActionResult<List<CategoryModel>>
}