package com.prilepskiy.domain.usecase

import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.domain.interactors.GetCategoryNetworkUseCase
import com.prilepskiy.domain.model.CategoryModel
import com.prilepskiy.domain.repository.CategoryRepository

class GetCategoryNetworkUseCaseImpl(private val repo: CategoryRepository): GetCategoryNetworkUseCase {
    override suspend fun invoke(): ActionResult<CategoryModel> {
        TODO("Not yet implemented")
    }
}