package com.prilepskiy.core.domain.usecase


import com.prilepskiy.core.data.utils.ActionResult
import com.prilepskiy.core.domain.interactors.GetDisheListNetworkUseCase
import com.prilepskiy.core.domain.model.DisheModel
import com.prilepskiy.core.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetDisheListNetworkUseCaseImpl(private val repo: DisheRepository):
    GetDisheListNetworkUseCase {
    override suspend operator fun invoke(): ActionResult<List<DisheModel>> = withContext(Dispatchers.IO){
        val apiData=repo.getDisheListNetwork()
        val result= mutableListOf<DisheModel>()
        return@withContext when(apiData){
            is ActionResult.Success -> {
                apiData.data.dishes.onEach{
                    result.add(DisheModel.from(it))
                }
                ActionResult.Success(result)
            }

            is ActionResult.Error -> {
                ActionResult.Error(apiData.errors)
            }
        }
    }
}