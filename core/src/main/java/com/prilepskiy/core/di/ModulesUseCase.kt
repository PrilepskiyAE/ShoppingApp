package com.prilepskiy.core.di

import com.prilepskiy.core.domain.interactors.GetBasketCashUseCase
import com.prilepskiy.core.domain.interactors.GetCategoryCashUseCase
import com.prilepskiy.core.domain.interactors.GetCategoryNetworkUseCase

import com.prilepskiy.core.domain.interactors.GetDisheByIdUseCase
import com.prilepskiy.core.domain.interactors.GetDisheByNameUseCase
import com.prilepskiy.core.domain.interactors.GetDisheByTagUseCase
import com.prilepskiy.core.domain.interactors.GetDisheListCashUseCase
import com.prilepskiy.core.domain.interactors.GetDisheListNetworkUseCase
import com.prilepskiy.core.domain.interactors.GetTagsUseCase
import com.prilepskiy.core.domain.interactors.SearchBtCashUseCase
import com.prilepskiy.core.domain.interactors.UpdateBasketCashUseCase
import com.prilepskiy.core.domain.usecase.GetBasketCashUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetCategoryCashUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetCategoryNetworkUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetDisheByIdUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetDisheByNameUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetDisheByTagUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetDisheListCashUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetDisheListNetworkUseCaseImpl
import com.prilepskiy.core.domain.usecase.GetTagsUseCaseImpl
import com.prilepskiy.core.domain.usecase.SearchBtCashUseCaseImpl
import com.prilepskiy.core.domain.usecase.UpdateBasketCashUseCaseImpl

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