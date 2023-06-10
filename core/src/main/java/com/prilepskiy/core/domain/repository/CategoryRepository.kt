package com.prilepskiy.core.domain.repository





import com.prilepskiy.core.data.apiService.response.categoryResponseModel.CategorieListResponse
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity
import com.prilepskiy.core.data.utils.ActionResult
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategoryNetwork(): ActionResult<CategorieListResponse>
    suspend fun getCategoryCash(): Flow<List<CategoryEntity>>
}