package com.prilepskiy.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.domain.model.BasketModel
import com.prilepskiy.domain.model.DisheModel
@Entity(tableName = "basket_table")
data class BasketEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val image_url: String,
    val name: String,
    val price: Int,
    val weight: Int,
    val colum:Int=1
    )
{
    companion object{
        fun from(data: DisheModel,colum: Int): BasketEntity = with(data) {
            BasketEntity(
                id = id,
                name = name,
                price = price,
                weight = weight,
                image_url = image_url,
                colum=colum
            )
        }
        fun from(data: BasketModel): BasketEntity = with(data) {
            BasketEntity(
                id = id,
                name = name,
                price = price,
                weight = weight,
                image_url = image_url,
                colum=colum
            )
        }
    }
}
