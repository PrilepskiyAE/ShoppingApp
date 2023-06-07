package com.prilepskiy.data.repository

import com.prilepskiy.data.apiService.DisheApiService
import com.prilepskiy.data.apiService.response.dishesResponseModel.DishesResponse

import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.data.utils.analyzeResponse
import com.prilepskiy.data.utils.makeApiCall
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.flow.Flow

class DisheRepositoryImpl(private val api: DisheApiService): DisheRepository {
    override suspend fun getDisheListNetwork(): ActionResult<DishesResponse> = makeApiCall {
        analyzeResponse(api.getDishe())
    }

    override suspend fun getDisheListCash(): Flow<DishesResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getDisheByCategory(categoryName: String): Flow<DishesResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun getDisheByName(disheName: String): Flow<DishesResponse>{
        TODO("Not yet implemented")
    }
}