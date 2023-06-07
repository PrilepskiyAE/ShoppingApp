package com.prilepskiy.sdk.data.apiservice


import com.prilepskiy.sdk.data.response.DisheResponse
import retrofit2.Response
import retrofit2.http.GET

interface DisheApiService {
    @GET(DISHE_URL)
    suspend fun  getDishe(): Response<List<DisheResponse>>
}