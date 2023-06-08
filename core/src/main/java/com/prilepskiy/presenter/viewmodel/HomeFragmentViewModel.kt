package com.prilepskiy.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.domain.interactors.GetCategoryNetworkUseCase
import com.prilepskiy.domain.model.CategoryModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val getCategoryNetworkUseCase: GetCategoryNetworkUseCase):ViewModel() {
    private val _categoryModel: MutableStateFlow<List<CategoryModel>?> by lazy {
        MutableStateFlow(
            null
        )
    }
    val categoryModel = _categoryModel.asStateFlow()

    fun getCategory(){
        viewModelScope.launch {
            when (val result = getCategoryNetworkUseCase()){
                is ActionResult.Success -> {
                    Log.d(TAG, "getCategory success: ${result.data.size}")
                    _categoryModel.emit(result.data)
                }
                is ActionResult.Error ->{
                    Log.d(TAG, "getCategory: error ${result.errors}")
                }
            }

        }
    }
    companion object{
       const val TAG="HomeFragmentViewModel"
    }
}