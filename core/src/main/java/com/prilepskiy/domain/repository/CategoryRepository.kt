package com.prilepskiy.domain.repository


import com.prilepskiy.data.apiService.response.CategoryResponseModel.CategoriesResponse
import com.prilepskiy.data.databaseService.entity.CategoryEntity
import com.prilepskiy.data.utils.ActionResult
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategoryNetwork(): ActionResult<CategoriesResponse>
    suspend fun getCategoryCash(): Flow<List<CategoryEntity>>
}