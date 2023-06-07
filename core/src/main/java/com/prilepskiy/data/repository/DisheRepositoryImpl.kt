package com.prilepskiy.data.repository

import com.prilepskiy.data.apiService.DisheApiService
import com.prilepskiy.data.apiService.response.dishesResponseModel.DishesResponse
import com.prilepskiy.data.databaseService.database.DisheDataBase
import com.prilepskiy.data.databaseService.entity.DisheEntity

import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.data.utils.analyzeResponse
import com.prilepskiy.data.utils.makeApiCall
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.first

class DisheRepositoryImpl(private val api: DisheApiService,private val db: DisheDataBase): DisheRepository {

    override suspend fun getDisheListNetwork(): ActionResult<DishesResponse> {
        //val result: DishesResponse ?= null
    val apiData= makeApiCall {
        analyzeResponse(api.getDishe())
    }
        return when(apiData){
            is ActionResult.Success -> {
                apiData.data.dishes.onEach {
                    db.disheDao.insert(
                        DisheEntity(
                            description = it.description,
                            id = it.id,
                            image_url = it.image_url,
                            name = it.name,
                            price = it.price,
                            tegs = it.tegs,
                            weight = it.weight
                        )
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
    override suspend fun getDisheById(disheId: Int): Flow<List<DisheEntity>> = db.disheDao.getDisheById(id = disheId)
}