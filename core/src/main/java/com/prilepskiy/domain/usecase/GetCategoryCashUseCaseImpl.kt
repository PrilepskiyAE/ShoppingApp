package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.domain.model.CategoryModel
import com.prilepskiy.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class GetCategoryCashUseCaseImpl(private val repo:CategoryRepository): GetCategoryCashUseCase {
    override suspend fun invoke(): Flow<List<CategoryModel>> {
        TODO("Not yet implemented")
    }
}