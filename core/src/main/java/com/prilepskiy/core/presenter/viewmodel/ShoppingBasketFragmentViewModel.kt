package com.prilepskiy.core.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.core.domain.interactors.GetAllSumUseCase
import com.prilepskiy.core.domain.interactors.GetBasketCashUseCase
import com.prilepskiy.core.domain.interactors.UpdateBasketCashUseCase
import com.prilepskiy.core.domain.model.BasketModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.job
import kotlinx.coroutines.launch

class ShoppingBasketFragmentViewModel(
    private val getBasketCashUseCase: GetBasketCashUseCase,
    private val updateBasketCashUseCase: UpdateBasketCashUseCase,
    private val getAllSumUseCase:GetAllSumUseCase
) : ViewModel() {
    private val _geolocation: MutableStateFlow<String?> by lazy {
        MutableStateFlow(
            null
        )
    }

    private val _basketModel: MutableStateFlow<List<BasketModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val basketModel = _basketModel.asStateFlow()

    private val _basketAllSumm: MutableStateFlow<Int?> = MutableStateFlow(0)
    val basketAllSumm = _basketAllSumm.asStateFlow()



    val geolocation = _geolocation.asStateFlow()
    fun getGeoCity(name: String) {
        viewModelScope.launch {
            _geolocation.emit(name)
        }
    }

    fun getBasket() {
        viewModelScope.launch {
            getBasketCashUseCase().collectLatest {
                _basketModel.emit(it)


            }
        }
    }

    fun updateBasketCash(basketModel: BasketModel, isPositive: Boolean) {
        viewModelScope.launch {
            if (isPositive) {

                updateBasketCashUseCase(basketModel.copy(colum = basketModel.colum+1))

            } else {

                updateBasketCashUseCase(basketModel.copy(colum = basketModel.colum-1))
            }


        }


    }




fun getAllSumm(){
    viewModelScope.launch {
        getAllSumUseCase.invoke().collect {

            _basketAllSumm.emit(it)

        }
    }


}

    override fun onCleared() {
        super.onCleared()
        viewModelScope.launch {
        updateBasketCashUseCase(basketModel.value?.get(0) !! )
        }
    }


}
