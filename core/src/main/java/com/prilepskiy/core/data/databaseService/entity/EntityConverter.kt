package com.prilepskiy.core.data.databaseService.entity

import androidx.room.TypeConverter
import com.google.gson.Gson

class EntityConverter {
    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()
}