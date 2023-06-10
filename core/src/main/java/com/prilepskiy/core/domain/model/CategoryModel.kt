package com.prilepskiy.core.domain.model


import com.prilepskiy.core.data.apiService.response.categoryResponseModel.CategoryResponse


import com.prilepskiy.core.data.databaseService.entity.CategoryEntity



data class CategoryModel(

    val id: Int=0,
    val image_url: String,
    val name: String){
    companion object {
        fun from(data: com.prilepskiy.core.data.databaseService.entity.CategoryEntity): com.prilepskiy.core.domain.model.CategoryModel = with(data) {
            com.prilepskiy.core.domain.model.CategoryModel(
                id = id,
                name = name,
                image_url = image_url
            )
        }

        fun from(data: com.prilepskiy.core.data.apiService.response.categoryResponseModel.CategoryResponse): com.prilepskiy.core.domain.model.CategoryModel = with(data) {
            com.prilepskiy.core.domain.model.CategoryModel(
                id = id,
                name = name,
                image_url = image_url
            )
        }



    }
}
