package com.prilepskiy.domain.repository


import com.prilepskiy.data.apiService.response.dishesResponseModel.DishesResponse
import com.prilepskiy.data.utils.ActionResult
import kotlinx.coroutines.flow.Flow


interface DisheRepository {
    suspend fun getDisheListNetwork(): ActionResult<DishesResponse>
    suspend fun getDisheListCash():Flow<DishesResponse>
    suspend fun getDisheByCategory(categoryName: String): Flow<DishesResponse>
    suspend fun getDisheByName(disheName: String): Flow<DishesResponse>
}