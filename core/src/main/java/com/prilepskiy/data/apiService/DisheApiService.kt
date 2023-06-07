package com.prilepskiy.data.apiService



import com.prilepskiy.data.apiService.response.dishesResponseModel.DishesListResponse
import retrofit2.Response
import retrofit2.http.GET

interface DisheApiService {
    @GET(DISHE_URL)
    suspend fun  getDishe(): Response<DishesListResponse>
}