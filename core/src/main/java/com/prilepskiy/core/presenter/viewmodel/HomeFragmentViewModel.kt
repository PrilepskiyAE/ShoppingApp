package com.prilepskiy.core.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.core.data.utils.ActionResult
import com.prilepskiy.core.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.core.domain.interactors.GetCategoryNetworkUseCase
import com.prilepskiy.core.domain.model.CategoryModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest


import kotlinx.coroutines.launch

class HomeFragmentViewModel(
    private val getCategoryNetworkUseCase: GetCategoryNetworkUseCase,
    private val getCategoryCashUseCase: GetCategoryCashUseCase
) : ViewModel() {
    private val _categoryModel: MutableStateFlow<List<CategoryModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val _geolocation: MutableStateFlow<String?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val categoryModel = _categoryModel.asStateFlow()
    val geolocation = _geolocation.asStateFlow()
    fun getCategory() {
        viewModelScope.launch {
            when (val result = getCategoryNetworkUseCase()) {
                is ActionResult.Success -> {
                    Log.d(TAG, "getCategory success: ${result.data.size}")
                    _categoryModel.emit(result.data)
                }

                is ActionResult.Error -> {
                    Log.d(TAG, "getCategory: error ${result.errors}")
                    getCategoryCashUseCase.invoke().collectLatest {
                        _categoryModel.emit(it)
                    }
                }
            }

        }
    }

    fun getGeoCity(name: String) {
        viewModelScope.launch {
            _geolocation.emit(name)
        }
    }

    companion object {
        const val TAG = "HomeFragmentViewModel"
    }
}