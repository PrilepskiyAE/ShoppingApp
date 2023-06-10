package com.prilepskiy.core.domain.usecase


import com.prilepskiy.core.data.utils.ActionResult
import com.prilepskiy.core.domain.interactors.GetCategoryNetworkUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import com.prilepskiy.core.domain.repository.CategoryRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GetCategoryNetworkUseCaseImpl(private val repo: CategoryRepository):
    GetCategoryNetworkUseCase {
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