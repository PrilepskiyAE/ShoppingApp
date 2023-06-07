package com.prilepskiy.data.databaseService.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

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
    )