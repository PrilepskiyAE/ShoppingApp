package com.prilepskiy.data.repository

import com.prilepskiy.data.apiService.CategoryApiService

import com.prilepskiy.data.apiService.response.CategoryResponseModel.CategoriesResponse
import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.data.utils.analyzeResponse
import com.prilepskiy.data.utils.makeApiCall
import com.prilepskiy.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(private val api: CategoryApiService): CategoryRepository {
    override suspend fun getCategoryNetwork(): ActionResult<CategoriesResponse> = makeApiCall {
        analyzeResponse(api.getCategory())
    }

    override suspend fun getCategoryCash(): Flow<CategoriesResponse> {
        TODO("Not yet implemented")
    }
}