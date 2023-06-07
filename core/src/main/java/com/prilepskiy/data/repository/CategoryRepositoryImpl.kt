package com.prilepskiy.data.repository

import com.prilepskiy.data.apiService.CategoryApiService

import com.prilepskiy.data.apiService.response.CategoryResponseModel.CategorieListResponse
import com.prilepskiy.data.databaseService.database.CategoryDataBase
import com.prilepskiy.data.databaseService.entity.CategoryEntity
import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.data.utils.analyzeResponse
import com.prilepskiy.data.utils.makeApiCall
import com.prilepskiy.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(private val api: CategoryApiService,private val db: CategoryDataBase): CategoryRepository {
    override suspend fun getCategoryNetwork(): ActionResult<CategorieListResponse> = makeApiCall {
        analyzeResponse(api.getCategory())
    }

    override suspend fun getCategoryCash(): Flow<List<CategoryEntity>> = db.categoryDao.getCategory()
}