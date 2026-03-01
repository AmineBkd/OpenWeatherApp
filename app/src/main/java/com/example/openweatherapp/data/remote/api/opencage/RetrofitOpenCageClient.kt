package com.example.openweatherapp.data.remote.api.opencage

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitOpenCageClient {
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(OpenCageService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val openCageService: OpenCageService by lazy {
        retrofit.create(OpenCageService::class.java)
    }
}