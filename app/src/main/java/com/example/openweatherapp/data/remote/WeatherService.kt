package com.example.openweatherapp.data.remote

import com.example.openweatherapp.data.model.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET("data/2.5/weather")
    suspend fun getCurrentWeather(
        @Query("q") cityName: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): WeatherData

    companion object {
        const val BASE_URL = "https://api.openweathermap.org/"
    }
}
