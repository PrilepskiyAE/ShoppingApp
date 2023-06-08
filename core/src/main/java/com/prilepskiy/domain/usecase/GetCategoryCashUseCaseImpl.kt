package com.prilepskiy.domain.usecase

import com.prilepskiy.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.domain.model.CategoryModel
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetCategoryCashUseCaseImpl(private val repo:CategoryRepository): GetCategoryCashUseCase {
    override suspend fun invoke(): Flow<List<CategoryModel>> = withContext(Dispatchers.IO){
       repo.getCategoryCash().map {
           val result: MutableList<CategoryModel> = mutableListOf()
           it.forEach {
               result.add(CategoryModel.from(it))
           }
           result

       }
    }
}