package com.prilepskiy.presenter.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prilepskiy.data.utils.ActionResult
import com.prilepskiy.domain.repository.DisheRepository

import kotlinx.coroutines.launch

class HomeFragmentViewModel(private val disheRepository: DisheRepository):ViewModel() {
    fun getDishe(){
        viewModelScope.launch {
            when (val result = disheRepository.getDisheListNetwork()){
                is ActionResult.Success -> {
                    Log.d(TAG, "getDishe1: ${result.data.dishes.size}")
                }
                is ActionResult.Error ->{
                    Log.d(TAG, "getDishe2: ${result.errors}")
                }
            }

        }
    }
    companion object{
       const val TAG="HomeFragmentViewModel"
    }
}