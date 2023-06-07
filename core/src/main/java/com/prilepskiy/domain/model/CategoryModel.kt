package com.prilepskiy.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class CategoryModel(

    val id: Int=0,
    val image_url: String,
    val name: String)