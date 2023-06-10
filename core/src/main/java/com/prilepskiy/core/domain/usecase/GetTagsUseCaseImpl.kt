package com.prilepskiy.core.domain.usecase


import com.prilepskiy.core.data.utils.ActionResult
import com.prilepskiy.core.domain.interactors.GetTagsUseCase
import com.prilepskiy.core.domain.model.TagModel
import com.prilepskiy.core.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

import kotlinx.coroutines.withContext

class GetTagsUseCaseImpl(private val repo: DisheRepository): GetTagsUseCase {
    override suspend fun invoke(): Flow<List<TagModel>> = withContext(Dispatchers.IO){
        val result:MutableList<List<TagModel>> = mutableListOf()

        when(val apiData =  repo.getDisheListNetwork()){
            is ActionResult.Success -> {
                apiData.data.dishes.onEach {
                    result.add(TagModel.from(it.tegs))
                }
            }
            is ActionResult.Error -> {
               repo.getDisheListCash().collect {
                   it.forEach {
                       result.add(TagModel.from(it.tegs))
                   }
               }
            }
        }


        result.asFlow()
    }
}