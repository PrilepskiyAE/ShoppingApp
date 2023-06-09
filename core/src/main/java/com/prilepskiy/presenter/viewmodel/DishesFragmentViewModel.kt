package com.prilepskiy.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.domain.interactors.GetDisheByTagUseCase
import com.prilepskiy.domain.interactors.GetTagsUseCase
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.model.TagModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class DishesFragmentViewModel(
    private val getDisheByTagUseCase: GetDisheByTagUseCase,
    private val getTagsUseCase: GetTagsUseCase
) : ViewModel() {

    private val _disheModel: MutableStateFlow<List<DisheModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    private val tempTegs= mutableSetOf<TagModel>()
    private val _tagsModel: MutableStateFlow<List<TagModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val tagsModel = _tagsModel.asStateFlow()
    val disheModel = _disheModel.asStateFlow()

    fun getDisheByTag(tag:TagModel=TagModel("Все меню",true),){
        viewModelScope.launch {
           getDisheByTagUseCase.invoke(tag.name).collect{
               Log.d(TAG, "getDisheByTag: ${it.size}")
               _disheModel.emit(it)
           }

        }
    }
    fun getTags( ){
        viewModelScope.launch {

            getTagsUseCase.invoke().collect {
                it.forEach {

                        tempTegs.add(it)
                }
                _tagsModel.emit(tempTegs.toList())
            }
        }

    }

    fun activ(item:TagModel,tagsList: List<TagModel>) {
        viewModelScope.launch {
            //_tagsModel.emit(null)
            tagsList.forEach {

            }
            var stationItems= mutableListOf<TagModel>()
             tagsList.forEach {
                 stationItems.add(it.copy(isActive = false))
             }
            var updatedItem = stationItems.find { it.name == item.name }
            val index = stationItems.indexOf(updatedItem)
            if (updatedItem != null) {
                updatedItem = updatedItem.copy(isActive = true)
            }
            if (index == -1) {
                _tagsModel.emit(tempTegs.toList())
            }
            stationItems = stationItems.toMutableList().apply {
                if (updatedItem != null) {
                    this[index] = updatedItem
                }
            }
            Log.d(TAG, "activ: $stationItems")
            _tagsModel.emit(stationItems)
    }
    }

    companion object {
      const val TAG="DishesFragmentViewModel" }
}