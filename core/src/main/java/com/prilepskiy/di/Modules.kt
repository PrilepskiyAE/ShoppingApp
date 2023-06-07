package com.prilepskiy.di

import com.prilepskiy.ui.viewmodel.HomeFragmentViewModel
import com.prilepskiy.ui.viewmodel.ProfileFragmentViewModel
import com.prilepskiy.ui.viewmodel.SearchFragmentViewModel
import com.prilepskiy.ui.viewmodel.ShoppingBasketFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeFragmentViewModel(get()) }
    viewModel { SearchFragmentViewModel() }
    viewModel { ShoppingBasketFragmentViewModel() }
    viewModel { ProfileFragmentViewModel() }
}