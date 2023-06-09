package com.prilepskiy.core.di


import android.app.Application
import androidx.room.Room
import com.prilepskiy.core.data.apiService.CategoryApiService
import com.prilepskiy.core.data.apiService.DisheApiService
import com.prilepskiy.core.data.databaseService.database.BasketDataBase
import com.prilepskiy.core.data.databaseService.database.CategoryDataBase
import com.prilepskiy.core.data.databaseService.database.DisheDataBase
import com.prilepskiy.core.data.repository.BasketRepositoryImpl
import com.prilepskiy.core.data.repository.CategoryRepositoryImpl
import com.prilepskiy.core.data.repository.DisheRepositoryImpl
import com.prilepskiy.core.data.utils.HeaderInterceptor
import com.prilepskiy.core.domain.repository.BasketRepository
import com.prilepskiy.core.domain.repository.CategoryRepository
import com.prilepskiy.core.domain.repository.DisheRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    fun retrofitService(api_url: String): Retrofit {

        return Retrofit.Builder()
            .baseUrl(api_url)
            .addConverterFactory(GsonConverterFactory.create())
            .apply {
                client(
                    OkHttpClient.Builder()
                        .addInterceptor(HeaderInterceptor())
                        .addInterceptor(HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        })
                        .readTimeout(1, TimeUnit.MINUTES)
                        .connectTimeout(1, TimeUnit.MINUTES)
                        .writeTimeout(1, TimeUnit.MINUTES)
                        .build()
                )
            }
            .build()
    }
    single<DisheApiService> {
        retrofitService("https://run.mocky.io/").create(
            DisheApiService::class.java
        )
    }
    single<CategoryApiService> {
        retrofitService("https://run.mocky.io/").create(
            CategoryApiService::class.java
        )
    }
}

val repositoryModule = module {
    single<CategoryRepository> { CategoryRepositoryImpl(get(), get()) }
    single<DisheRepository> { DisheRepositoryImpl(get(), get()) }
    single<BasketRepository> { BasketRepositoryImpl(get()) }
}

val databaseModule = module {
    fun provideDisheDataBase(application: Application): DisheDataBase {
        return Room.databaseBuilder(
            application,
            DisheDataBase::class.java,
            "DisheDB"
        ).allowMainThreadQueries()
            .build()
    }
    single { provideDisheDataBase(androidApplication()) }
    single { get<DisheDataBase>().disheDao }

    fun provideCategoryDataBase(application: Application): CategoryDataBase {
        return Room.databaseBuilder(
            application,
            CategoryDataBase::class.java,
            "CategoryDB"
        ).allowMainThreadQueries()
            .build()
    }
    single { provideCategoryDataBase(androidApplication()) }
    single { get<CategoryDataBase>().categoryDao }

    fun provideBasketDataBase(application: Application): BasketDataBase {
        return Room.databaseBuilder(
            application,
            BasketDataBase::class.java,
            "BasketDB"
        ).allowMainThreadQueries()
            .build()
    }



    single { provideBasketDataBase(androidApplication()) }
    single { get<BasketDataBase>().basketDao }

}