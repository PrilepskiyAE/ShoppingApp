package com.prilepskiy.domain.model

import com.prilepskiy.data.databaseService.entity.BasketEntity

data class BasketModel(
    val id: Int=0,
    val image_url: String,
    val name: String,
    val price: Int,
    val weight: Int,
    val colum:Int=1
) {
    companion object{
        fun from(data: BasketEntity): BasketModel = with(data) {
            BasketModel(
                id = id,
                name = name,
                price = price,
                weight = weight,
                image_url = image_url,
                colum=colum
            )
        }

        fun from(data: DisheModel): BasketModel = with(data) {
            BasketModel(
                id = id,
                name = name,
                price = price,
                weight = weight,
                image_url = image_url,

                )
        }
    }

}

