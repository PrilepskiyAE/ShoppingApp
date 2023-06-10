package com.prilepskiy.presenter.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ShoppingBasketFragmentViewModel(): ViewModel() {
    val _geolocation : MutableStateFlow<String?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val geolocation=_geolocation.asStateFlow()
    fun getGeoCity(name: String) {
        viewModelScope.launch {
            _geolocation.emit(name)
        }
    }
}