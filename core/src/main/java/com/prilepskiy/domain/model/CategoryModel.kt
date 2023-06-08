package com.prilepskiy.domain.model


import com.prilepskiy.data.apiService.response.categoryResponseModel.CategoryResponse


import com.prilepskiy.data.databaseService.entity.CategoryEntity



data class CategoryModel(

    val id: Int=0,
    val image_url: String,
    val name: String){
    companion object {
        fun from(data: CategoryEntity): CategoryModel = with(data) {
            CategoryModel(
                id = id,
                name = name,
                image_url = image_url
            )
        }

        fun from(data: CategoryResponse): CategoryModel = with(data) {
            CategoryModel(
                id = id,
                name = name,
                image_url = image_url
            )
        }

//        fun from(data: List<CategoryEntity>):List<CategoryModel> {
//            val temp:MutableList<CategoryModel> = mutableListOf()
//            data.forEach {
//                temp.add(CategoryModel.from(it))
//            }
//            return temp
//        }
//        fun from(data: List<CategoryResponse>):List<CategoryModel> {
//            val temp:MutableList<CategoryModel> = mutableListOf()
//            data.forEach {
//                temp.add(CategoryModel.from(it))
//            }
//            return temp
//        }

    }
}
