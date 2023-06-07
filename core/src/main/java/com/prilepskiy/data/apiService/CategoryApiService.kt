package com.prilepskiy.data.apiService


import com.prilepskiy.data.apiService.response.CategoryResponseModel.CategorieListResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiService {
    @GET(CATEGORY_URL)
    suspend fun  getCategory():Response<CategorieListResponse>
}