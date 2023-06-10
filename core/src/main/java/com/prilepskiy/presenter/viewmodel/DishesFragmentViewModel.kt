package com.prilepskiy.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.domain.interactors.GetDisheByTagUseCase
import com.prilepskiy.domain.interactors.GetTagsUseCase
import com.prilepskiy.domain.interactors.SearchBtCashUseCase
import com.prilepskiy.domain.interactors.UpdateBasketCashUseCase
import com.prilepskiy.domain.model.BasketModel
import com.prilepskiy.domain.model.DisheModel
import com.prilepskiy.domain.model.TagModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.lastOrNull
import kotlinx.coroutines.flow.toSet
import kotlinx.coroutines.launch

class DishesFragmentViewModel(
    private val getDisheByTagUseCase: GetDisheByTagUseCase,
    private val getTagsUseCase: GetTagsUseCase,
    private val updateBasketCashUseCase: UpdateBasketCashUseCase,
    private val searchBtCashUseCase: SearchBtCashUseCase
) : ViewModel() {

    private val _disheModel: MutableStateFlow<List<DisheModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    private val tempTegs = mutableSetOf<TagModel>()
    private val _tagsModel: MutableStateFlow<List<TagModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }

    private val _basketModel: MutableStateFlow<BasketModel?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val basketModel = _basketModel.asStateFlow()
    val tagsModel = _tagsModel.asStateFlow()
    val disheModel = _disheModel.asStateFlow()

    fun getDisheByTag(tag: TagModel = TagModel("Все меню", true)) {
        viewModelScope.launch {
            getDisheByTagUseCase.invoke(tag.name).collect {
                Log.d(TAG, "getDisheByTag: ${it.size}")
                _disheModel.emit(it)
            }

        }
    }

    fun getTags() {
        viewModelScope.launch {

            getTagsUseCase().collect {
                it.forEach {

                    tempTegs.add(it)
                }
                _tagsModel.emit(tempTegs.toList())
            }
        }

    }

    fun searchBasketCash(disheModel: DisheModel) {


        viewModelScope.launch {
            searchBtCashUseCase(BasketModel.from(disheModel)).collectLatest {

                _basketModel.emit(it)
            }

        }


    }
    fun addBasketCash(disheModel: DisheModel) {
        viewModelScope.launch {

            searchBtCashUseCase(BasketModel.from(disheModel)).collect {


                if (it?.name==disheModel.name){
                    Log.d(TAG, "addBasketCash1: ${disheModel.name}")
                    updateBasketCashUseCase.invoke(BasketModel.from(disheModel).copy(colum = it.colum+1))
                    this.cancel()
                }else{
                    Log.d(TAG, "addBasketCash2: ${it?.name}")
                    updateBasketCashUseCase.invoke(BasketModel.from(disheModel))
                    this.cancel()
                }


               
            }
            


        }





    }

    fun activatioTeg(item: TagModel, tagsList: List<TagModel>) {
        viewModelScope.launch {
            //_tagsModel.emit(null)
            tagsList.forEach {

            }
            var stationItems = mutableListOf<TagModel>()
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
        const val TAG = "DishesFragmentViewModel"
    }
}