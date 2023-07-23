package com.prilepskiy.core.data.repository

import com.prilepskiy.core.data.apiService.DisheApiService
import com.prilepskiy.core.data.apiService.response.dishesResponseModel.DishesListResponse
import com.prilepskiy.core.data.databaseService.database.DisheDataBase
import com.prilepskiy.core.data.databaseService.entity.DisheEntity
import com.prilepskiy.core.data.utils.ActionResult
import com.prilepskiy.core.data.utils.analyzeResponse
import com.prilepskiy.core.data.utils.makeApiCall
import com.prilepskiy.core.domain.repository.DisheRepository


import kotlinx.coroutines.flow.Flow

class DisheRepositoryImpl(private val api: DisheApiService, private val db: DisheDataBase):
    DisheRepository {

    override suspend fun getDisheListNetwork(): ActionResult<DishesListResponse> {
        //val result: DishesListResponse ?= null
    val apiData= makeApiCall {
        analyzeResponse(api.getDishe())
    }
        return when(apiData){
            is ActionResult.Success -> {
                apiData.data.dishes.onEach {
                    db.disheDao.insert(
                        DisheEntity.from(it)
                    )
                }

                ActionResult.Success(apiData.data)
            }
            is ActionResult.Error -> {
                ActionResult.Error(apiData.errors)
            }
        }
}
    override suspend fun getDisheListCash(): Flow<List<DisheEntity>> = db.disheDao.getDishe()
    override suspend fun getDisheByName(disheName: String): Flow<List<DisheEntity>> = db.disheDao.getDisheByName(disheName)
    override suspend fun getDisheById(disheId: Int): Flow<List<DisheEntity>> = db.disheDao.getDisheById(disheId)
    override suspend fun getDisheByTags(tagName: String): Flow<List<DisheEntity>> = db.disheDao.getDisheByTags(tagName)
    override suspend fun searchDisheByName(query: String): Flow<List<DisheEntity>> = db.disheDao.searchDisheByName(query)
}