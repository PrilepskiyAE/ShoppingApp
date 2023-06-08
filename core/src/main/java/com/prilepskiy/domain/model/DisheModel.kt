package com.prilepskiy.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.prilepskiy.data.apiService.response.dishesResponseModel.DisheResponse
import com.prilepskiy.data.databaseService.entity.DisheEntity


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
        fun from(data: DisheEntity): DisheModel = with(data) {
            DisheModel(
                id = id,
                name = name,
                description = description,
                price = price,
                tegs = tegs,
                weight = weight,
                image_url = image_url
            )
        }

        fun from(data: DisheResponse): DisheModel = with(data) {
            DisheModel(
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

