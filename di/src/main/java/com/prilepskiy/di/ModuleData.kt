package com.prilepskiy.di

import com.prilepskiy.sdk.data.apiservice.CategoryApiService
import com.prilepskiy.sdk.data.apiservice.DisheApiService
import com.prilepskiy.sdk.data.utils.HeaderInterceptor
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
    single<DisheApiService> { retrofitService(BuildConfig.API_URL).create(DisheApiService::class.java) }
    single<CategoryApiService> { retrofitService(BuildConfig.API_URL).create(CategoryApiService::class.java) }
}

val repositoryModule = module{}

val databaseModule = module {}