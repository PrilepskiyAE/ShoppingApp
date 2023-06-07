package com.prilepskiy.domain.interactors


import com.prilepskiy.domain.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface GetCategoryCashUseCase {
    suspend operator fun invoke(): Flow<List<CategoryModel>>
}