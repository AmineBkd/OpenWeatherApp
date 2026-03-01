package com.example.openweatherapp.data.remote.repository

import android.util.Log
import com.example.openweatherapp.data.local.WeatherDao
import com.example.openweatherapp.data.local.WeatherDatabase
import com.example.openweatherapp.data.remote.api.openmeteo.RetrofitWeatherClient
import com.example.openweatherapp.data.remote.api.openmeteo.WeatherService
import com.example.openweatherapp.data.model.WeatherResponse
import com.example.openweatherapp.domain.repository.WeatherRepository
import javax.inject.Inject

//TODO: Add Caching for this repository using weatherDao
class WeatherRepositoryImpl @Inject constructor(weatherDatabase: WeatherDatabase) : WeatherRepository {
    private val weatherService: WeatherService = RetrofitWeatherClient.weatherService
    private val weatherDao: WeatherDao = weatherDatabase.weatherDao()

    override suspend fun getWeather(latitude: Double, longitude: Double): WeatherResponse? {
        return try {
            val remote = weatherService.getCurrentWeather(latitude = latitude, longitude = longitude)
            return remote
        } catch (e: Exception) {
            Log.d("Repository Call Failure | refreshWeather", "${e.cause} ${e.message}")
            null
        }
    }
}