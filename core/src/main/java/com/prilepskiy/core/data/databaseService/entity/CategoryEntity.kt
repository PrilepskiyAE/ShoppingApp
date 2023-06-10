package com.prilepskiy.core.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.prilepskiy.core.data.apiService.response.categoryResponseModel.CategoryResponse

@Entity(tableName = "category_table")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val image_url: String,
    val name: String
) {
    companion object {
        fun from(data: CategoryResponse): CategoryEntity = with(data) {
            CategoryEntity(id, image_url, name)
        }

    }
}
