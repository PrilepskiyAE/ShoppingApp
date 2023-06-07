package com.prilepskiy.data.apiservice


import com.prilepskiy.data.response.CategoryResponseModel.CategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiService {
    @GET(CATEGORY_URL)
    suspend fun  getCategory():Response<CategoriesResponse>
}