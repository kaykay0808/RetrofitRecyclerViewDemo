package com.kay.retrofitrecyclerviewdemo

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.kay.retrofitrecyclerviewdemo.data.ApiInterface
import com.kay.retrofitrecyclerviewdemo.ui.MyRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType

import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {
    single { MyRepository(get()) }
    single<ApiInterface> {
        val contentType = "application/json".toMediaType()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(Json{ignoreUnknownKeys = true}.asConverterFactory(contentType))
            .build()
        retrofit.create(ApiInterface::class.java)
    }
}