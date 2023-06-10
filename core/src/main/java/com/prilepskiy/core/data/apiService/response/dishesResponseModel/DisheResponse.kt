package com.prilepskiy.core.data.apiService.response.dishesResponseModel

data class DisheResponse(
    val description: String="",
    val id: Int=0,
    val image_url: String="",
    val name: String="",
    val price: Int=0,
    val tegs: List<String> = listOf(),
    val weight: Int=0
)