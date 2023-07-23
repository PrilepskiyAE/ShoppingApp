package com.prilepskiy.core.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.core.domain.interactors.SearchBtCashUseCase
import com.prilepskiy.core.domain.interactors.SearchDisheByNameUseCase
import com.prilepskiy.core.domain.interactors.UpdateBasketCashUseCase
import com.prilepskiy.core.domain.model.BasketModel
import com.prilepskiy.core.domain.model.DisheModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SearchFragmentViewModel(private val updateBasketCashUseCase: UpdateBasketCashUseCase,
                              private val searchBtCashUseCase: SearchBtCashUseCase,
                              private val searchDisheByNameUseCase: SearchDisheByNameUseCase
): ViewModel() {

    private val _disheModel: MutableStateFlow<List<DisheModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val disheModel = _disheModel.asStateFlow()
    fun addBasketCash(disheModel: DisheModel) {
        viewModelScope.launch {

            searchBtCashUseCase(BasketModel.from(disheModel)).collect {


                if (it?.name==disheModel.name){
                    Log.d(DishesFragmentViewModel.TAG, "addBasketCash1: ${disheModel.name}")
                    updateBasketCashUseCase.invoke(BasketModel.from(disheModel).copy(colum = it.colum+1))
                    this.cancel()
                }else{
                    Log.d(DishesFragmentViewModel.TAG, "addBasketCash2: ${it?.name}")
                    updateBasketCashUseCase.invoke(BasketModel.from(disheModel))
                    this.cancel()
                }

            }

        }





    }
    fun getDisheQuery(query:String){
        viewModelScope.launch {
            searchDisheByNameUseCase(query).collect {

                _disheModel.emit(it)
            }
        }
    }
}