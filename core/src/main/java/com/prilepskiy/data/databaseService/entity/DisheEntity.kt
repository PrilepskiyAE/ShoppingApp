package com.prilepskiy.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dishe_table")
class DisheEntity(
    val description: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    val image_url: String,
    val name: String,
    val price: Int,
    //val tegs: List<String>,
    val weight: Int
    )