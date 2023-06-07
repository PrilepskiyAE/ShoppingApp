package com.prilepskiy.di

import com.prilepskiy.sdk.ui.fragments.homeFragment.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeFragmentViewModel() }
}