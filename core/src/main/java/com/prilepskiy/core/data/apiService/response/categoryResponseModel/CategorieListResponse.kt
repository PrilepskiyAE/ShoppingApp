package com.prilepskiy.core.data.apiService.response.categoryResponseModel

import com.google.gson.annotations.SerializedName

data class CategorieListResponse(

@SerializedName("сategories") val categories: List<CategoryResponse> = listOf()
)