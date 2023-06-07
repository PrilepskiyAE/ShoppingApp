package com.prilepskiy.di

import com.prilepskiy.presenter.viewmodel.HomeFragmentViewModel
import com.prilepskiy.presenter.viewmodel.ProfileFragmentViewModel
import com.prilepskiy.presenter.viewmodel.SearchFragmentViewModel
import com.prilepskiy.presenter.viewmodel.ShoppingBasketFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeFragmentViewModel(get()) }
    viewModel { SearchFragmentViewModel() }
    viewModel { ShoppingBasketFragmentViewModel() }
    viewModel { ProfileFragmentViewModel() }
}