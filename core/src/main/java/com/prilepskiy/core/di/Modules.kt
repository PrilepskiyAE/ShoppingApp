package com.prilepskiy.core.di

import com.prilepskiy.core.presenter.viewmodel.DishesFragmentViewModel
import com.prilepskiy.core.presenter.viewmodel.HomeFragmentViewModel
import com.prilepskiy.core.presenter.viewmodel.ProfileFragmentViewModel
import com.prilepskiy.core.presenter.viewmodel.SearchFragmentViewModel
import com.prilepskiy.core.presenter.viewmodel.ShoppingBasketFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeFragmentViewModel(get(),get()) }
    viewModel { SearchFragmentViewModel() }
    viewModel { ShoppingBasketFragmentViewModel(get(),get(),get()) }
    viewModel { ProfileFragmentViewModel() }
    viewModel { DishesFragmentViewModel(get(),get(),get(),get()) }

    }