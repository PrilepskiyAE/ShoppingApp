package com.prilepskiy.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters



class DisheModel(
    val description: String,
    val id: Int,
    val image_url: String,
    val name: String,
    val price: Int,
    val tegs: List<String>,
    val weight: Int
    )