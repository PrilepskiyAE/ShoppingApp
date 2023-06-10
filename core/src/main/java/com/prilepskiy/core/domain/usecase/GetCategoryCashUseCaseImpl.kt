package com.prilepskiy.core.domain.usecase

import com.prilepskiy.core.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class GetCategoryCashUseCaseImpl(private val repo: CategoryRepository):
    GetCategoryCashUseCase {
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