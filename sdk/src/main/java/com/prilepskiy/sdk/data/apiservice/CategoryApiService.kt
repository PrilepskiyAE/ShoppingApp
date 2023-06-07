package com.prilepskiy.sdk.data.apiservice

import com.prilepskiy.sdk.data.response.CategoryResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryApiService {
    @GET(CATEGORY_URL)
    suspend fun  getCategory():Response<List<CategoryResponse>>
}