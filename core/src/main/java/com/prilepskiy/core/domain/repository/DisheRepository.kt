package com.prilepskiy.core.domain.repository




import com.prilepskiy.core.data.apiService.response.dishesResponseModel.DishesListResponse
import com.prilepskiy.core.data.databaseService.entity.DisheEntity
import com.prilepskiy.core.data.utils.ActionResult
import kotlinx.coroutines.flow.Flow


interface DisheRepository {
    suspend fun getDisheListNetwork(): ActionResult<DishesListResponse>
    suspend fun getDisheListCash(): Flow<List<DisheEntity>>
    suspend fun getDisheByName(disheName: String): Flow<List<DisheEntity>>
    suspend fun getDisheById(disheId: Int): Flow<List<DisheEntity>>
    suspend fun getDisheByTags(tagName: String): Flow<List<DisheEntity>>
}