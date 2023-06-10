package com.prilepskiy.core.di

import android.app.Application
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ShoppingApp:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            androidLogger(if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            modules(modules)
        }
    }
    private val modules = listOf(
        apiModule,
        repositoryModule,
        useCaseModule,
        viewModelModule,
        databaseModule
    )
}