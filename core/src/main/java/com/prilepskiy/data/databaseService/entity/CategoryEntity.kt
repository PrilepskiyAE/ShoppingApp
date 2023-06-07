package com.prilepskiy.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_table")
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val image_url: String,
    val name: String)