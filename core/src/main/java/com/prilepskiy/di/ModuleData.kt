package com.prilepskiy.di


import com.prilepskiy.data.apiService.CategoryApiService
import com.prilepskiy.data.apiService.DisheApiService
import com.prilepskiy.data.repository.CategoryRepositoryImpl
import com.prilepskiy.data.repository.DisheRepositoryImpl
import com.prilepskiy.data.utils.HeaderInterceptor
import com.prilepskiy.domain.repository.CategoryRepository
import com.prilepskiy.domain.repository.DisheRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule = module {
    fun retrofitService(api_url:String): Retrofit {

        return  Retrofit.Builder()
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
    single<DisheApiService> { retrofitService("https://run.mocky.io/").create(DisheApiService::class.java) }
    single<CategoryApiService> { retrofitService("https://run.mocky.io/").create(CategoryApiService::class.java) }
}

val repositoryModule = module{
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<DisheRepository> { DisheRepositoryImpl(get()) }
}

val databaseModule = module {}