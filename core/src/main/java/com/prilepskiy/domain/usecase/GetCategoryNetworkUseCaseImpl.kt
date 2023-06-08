package com.prilepskiy.domain.usecase

import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.domain.interactors.GetCategoryNetworkUseCase
import com.prilepskiy.domain.model.CategoryModel
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCategoryNetworkUseCaseImpl(private val repo: CategoryRepository): GetCategoryNetworkUseCase {
    override suspend operator fun invoke(): ActionResult<List<CategoryModel>> = withContext(Dispatchers.IO){
        val apiData=repo.getCategoryNetwork()
        val result= mutableListOf<CategoryModel>()
        return@withContext when(apiData){
            is ActionResult.Success -> {
                apiData.data.categories.onEach{
                    result.add(CategoryModel.from(it))
                }
                ActionResult.Success(result)
            }

            is ActionResult.Error -> {
                ActionResult.Error(apiData.errors)
            }
        }
    }
}