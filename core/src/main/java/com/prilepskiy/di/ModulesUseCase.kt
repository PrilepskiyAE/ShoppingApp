package com.prilepskiy.di

import com.prilepskiy.domain.interactors.GetBasketCashUseCase
import com.prilepskiy.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.domain.interactors.GetCategoryNetworkUseCase

import com.prilepskiy.domain.interactors.GetDisheByIdUseCase
import com.prilepskiy.domain.interactors.GetDisheByNameUseCase
import com.prilepskiy.domain.interactors.GetDisheByTagUseCase
import com.prilepskiy.domain.interactors.GetDisheListCashUseCase
import com.prilepskiy.domain.interactors.GetDisheListNetworkUseCase
import com.prilepskiy.domain.interactors.GetTagsUseCase
import com.prilepskiy.domain.interactors.SearchBtCashUseCase
import com.prilepskiy.domain.interactors.UpdateBasketCashUseCase
import com.prilepskiy.domain.usecase.GetBasketCashUseCaseImpl
import com.prilepskiy.domain.usecase.GetCategoryCashUseCaseImpl
import com.prilepskiy.domain.usecase.GetCategoryNetworkUseCaseImpl

import com.prilepskiy.domain.usecase.GetDisheByIdUseCaseImpl
import com.prilepskiy.domain.usecase.GetDisheByNameUseCaseImpl
import com.prilepskiy.domain.usecase.GetDisheByTagUseCaseImpl
import com.prilepskiy.domain.usecase.GetDisheListCashUseCaseImpl
import com.prilepskiy.domain.usecase.GetDisheListNetworkUseCaseImpl
import com.prilepskiy.domain.usecase.GetTagsUseCaseImpl
import com.prilepskiy.domain.usecase.SearchBtCashUseCaseImpl
import com.prilepskiy.domain.usecase.UpdateBasketCashUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetCategoryCashUseCase> { GetCategoryCashUseCaseImpl(get()) }
    factory<GetCategoryNetworkUseCase> { GetCategoryNetworkUseCaseImpl(get()) }
    factory<GetDisheByTagUseCase> { GetDisheByTagUseCaseImpl(get()) }
    factory<GetDisheByIdUseCase> { GetDisheByIdUseCaseImpl(get()) }
    factory<GetDisheByNameUseCase> { GetDisheByNameUseCaseImpl(get()) }
    factory<GetDisheListCashUseCase> { GetDisheListCashUseCaseImpl(get()) }
    factory<GetDisheListNetworkUseCase> { GetDisheListNetworkUseCaseImpl(get()) }
    factory<GetTagsUseCase> { GetTagsUseCaseImpl(get()) }
    factory<GetBasketCashUseCase> { GetBasketCashUseCaseImpl(get()) }
    factory<UpdateBasketCashUseCase> { UpdateBasketCashUseCaseImpl(get()) }
    factory<SearchBtCashUseCase> { SearchBtCashUseCaseImpl(get()) }
}