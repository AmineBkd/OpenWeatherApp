package com.example.openweatherapp.data.remote.api.openmeteo

import com.example.openweatherapp.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("v1/forecast")
    suspend fun getCurrentWeather(
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
        @Query("current") current: String = "temperature_2m,relative_humidity_2m,wind_speed_10m,rain,precipitation,precipitation_probability,apparent_temperature,showers,snowfall",
        @Query("hourly") hourly: String = "temperature_2m,relative_humidity_2m,wind_speed_10m"
    ) : WeatherResponse

    companion object {
        const val BASE_URL = "https://api.open-meteo.com/"
    }
}