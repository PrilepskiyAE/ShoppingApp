package com.prilepskiy.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.prilepskiy.data.apiService.response.dishesResponseModel.DisheResponse
import com.prilepskiy.domain.model.DisheModel

@Entity(tableName = "dishe_table")
@TypeConverters(EntityConverter::class)
class DisheEntity(
    val description: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val image_url: String,
    val name: String,
    val price: Int,
    val tegs: List<String>,
    val weight: Int
    ){
    companion object {
        fun from(data: DisheModel): DisheEntity = with(data) {
            DisheEntity(
                id = id,
                name = name,
                description = description,
                price = price,
                tegs = tegs,
                weight = weight,
                image_url = image_url
            )
        }

        fun from(data: DisheResponse): DisheEntity = with(data) {
            DisheEntity(
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