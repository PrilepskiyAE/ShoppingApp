package com.prilepskiy.core.domain.interactors


import com.prilepskiy.core.domain.model.CategoryModel
import kotlinx.coroutines.flow.Flow

interface GetCategoryCashUseCase {
    suspend operator fun invoke(): Flow<List<com.prilepskiy.core.domain.model.CategoryModel>>
}