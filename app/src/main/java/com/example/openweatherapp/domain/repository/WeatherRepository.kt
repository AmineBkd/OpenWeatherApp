package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.data.model.WeatherResponse

interface WeatherRepository {
    suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponse?
}