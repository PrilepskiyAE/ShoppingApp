package com.prilepskiy.core.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.prilepskiy.core.data.apiService.response.dishesResponseModel.DisheResponse
import com.prilepskiy.core.data.databaseService.entity.DisheEntity


class DisheModel(
    val description: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val price: Int,
    val tegs: List<String>,
    val weight: Int
) {
    companion object {
        fun from(data: com.prilepskiy.core.data.databaseService.entity.DisheEntity): com.prilepskiy.core.domain.model.DisheModel = with(data) {
            com.prilepskiy.core.domain.model.DisheModel(
                id = id,
                name = name,
                description = description,
                price = price,
                tegs = tegs,
                weight = weight,
                image_url = image_url
            )
        }

        fun from(data: com.prilepskiy.core.data.apiService.response.dishesResponseModel.DisheResponse): com.prilepskiy.core.domain.model.DisheModel = with(data) {
            com.prilepskiy.core.domain.model.DisheModel(
                id = id,
                name = name,
                description = description,
                price = price,
                tegs = tegs,
                weight = weight,
                image_url = image_url
            )
        }


    }

    }

