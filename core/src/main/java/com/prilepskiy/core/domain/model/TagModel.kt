package com.prilepskiy.core.domain.model

data class TagModel(val name:String,val isActive:Boolean){
    companion object{
        fun from(list: List<String>):List<com.prilepskiy.core.domain.model.TagModel>{
            val result: MutableList<com.prilepskiy.core.domain.model.TagModel> = mutableListOf()
            list.forEach {
                if (it=="Все меню")
                    result.add(com.prilepskiy.core.domain.model.TagModel(it, true))
                else
                    result.add(com.prilepskiy.core.domain.model.TagModel(it, false))

            }
            return result
        }
    }
}