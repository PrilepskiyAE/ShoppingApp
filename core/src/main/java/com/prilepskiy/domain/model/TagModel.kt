package com.prilepskiy.domain.model

data class TagModel(val name:String,val isActive:Boolean){
    companion object{
        fun from(list: List<String>):List<TagModel>{
            val result: MutableList<TagModel> = mutableListOf()
            list.forEach {
                if (it=="Все меню")
                    result.add(TagModel(it,true))
                else
                    result.add(TagModel(it,false))

            }
            return result
        }
    }
}