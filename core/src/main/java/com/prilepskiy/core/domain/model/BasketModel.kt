package com.prilepskiy.core.domain.model

import com.prilepskiy.core.data.databaseService.entity.BasketEntity

data class BasketModel(
    val id: Int=0,
    val image_url: String,
    val name: String,
    val price: Int,
    val weight: Int,
    val colum:Int=1
) {
    companion object{
        fun from(data: com.prilepskiy.core.data.databaseService.entity.BasketEntity): com.prilepskiy.core.domain.model.BasketModel = with(data) {
            com.prilepskiy.core.domain.model.BasketModel(
                id = id,
                name = name,
                price = price,
                weight = weight,
                image_url = image_url,
                colum = colum
            )
        }

        fun from(data: com.prilepskiy.core.domain.model.DisheModel): com.prilepskiy.core.domain.model.BasketModel = with(data) {
            com.prilepskiy.core.domain.model.BasketModel(
                id = id,
                name = name,
                price = price,
                weight = weight,
                image_url = image_url,

                )
        }
    }

}

