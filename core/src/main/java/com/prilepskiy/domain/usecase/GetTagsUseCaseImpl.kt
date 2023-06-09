package com.prilepskiy.domain.usecase

import android.util.Log
import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.domain.interactors.GetTagsUseCase
import com.prilepskiy.domain.model.TagModel
import com.prilepskiy.domain.repository.DisheRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
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