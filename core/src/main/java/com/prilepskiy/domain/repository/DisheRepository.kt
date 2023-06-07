package com.prilepskiy.domain.repository


import com.prilepskiy.data.apiService.response.dishesResponseModel.DishesListResponse
import com.prilepskiy.data.databaseService.entity.DisheEntity
import com.prilepskiy.data.utils.ActionResult
import kotlinx.coroutines.flow.Flow


interface DisheRepository {
    suspend fun getDisheListNetwork(): ActionResult<DishesListResponse>
    suspend fun getDisheListCash(): Flow<List<DisheEntity>>
    suspend fun getDisheByName(disheName: String): Flow<List<DisheEntity>>
    suspend fun getDisheById(disheId: Int): Flow<List<DisheEntity>>

    suspend fun getDisheByCategory(categoryName: String): Flow<List<DisheEntity>>
}