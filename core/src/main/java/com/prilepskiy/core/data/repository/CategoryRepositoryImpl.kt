package com.prilepskiy.core.data.repository




import com.prilepskiy.core.data.apiService.CategoryApiService
import com.prilepskiy.core.data.apiService.response.categoryResponseModel.CategorieListResponse
import com.prilepskiy.core.data.databaseService.database.CategoryDataBase
import com.prilepskiy.core.data.databaseService.entity.CategoryEntity
import com.prilepskiy.core.data.databaseService.entity.DisheEntity
import com.prilepskiy.core.data.utils.ActionResult
import com.prilepskiy.core.data.utils.analyzeResponse
import com.prilepskiy.core.data.utils.makeApiCall
import com.prilepskiy.core.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class CategoryRepositoryImpl(private val api: CategoryApiService, private val db: CategoryDataBase):
    CategoryRepository {
    override suspend fun getCategoryNetwork(): ActionResult<CategorieListResponse> {

        val apiData= makeApiCall {
            analyzeResponse(api.getCategory())
        }
        return when(apiData){
            is ActionResult.Success -> {
                apiData.data.categories.onEach {
                    db.categoryDao.insert(
                        CategoryEntity.from(it)
                    )
                }

                ActionResult.Success(apiData.data)
            }
            is ActionResult.Error -> {
                ActionResult.Error(apiData.errors)
            }
        }
    }

    override suspend fun getCategoryCash(): Flow<List<CategoryEntity>> = db.categoryDao.getCategory()
}