package com.example.openweatherapp.data.repository

import android.util.Log
import com.example.openweatherapp.data.local.WeatherDao
import com.example.openweatherapp.data.local.WeatherDatabase
import com.example.openweatherapp.data.remote.api.openmeteo.RetrofitWeatherClient
import com.example.openweatherapp.data.remote.api.openmeteo.WeatherService
import com.example.openweatherapp.model.WeatherResponse
import javax.inject.Inject

class WeatherRepository @Inject constructor(weatherDatabase: WeatherDatabase) {
    private val weatherService: WeatherService = RetrofitWeatherClient.weatherService
    private val weatherDao: WeatherDao = weatherDatabase.weatherDao()

    //fun observeWeather(cityName: String): Flow<WeatherEntity?> = weatherDao.observeWeather(cityName)

    suspend fun refreshWeather(forceRefresh: Boolean = false): WeatherResponse? {
        return try {
            /*if (!forceRefresh) {
                val cached = weatherDao.getWeather(cityName)
                if (cached != null && !isStale(cached.timestamp)) {
                    return cached.toWeatherData()
                }
            }*/

            val remote = weatherService.getCurrentWeather(latitude = 52.52, longitude = 13.41)
            return remote
        } catch (e: Exception) {
            Log.d("Repository Call Failure | refreshWeather", "${e.cause} ${e.message}")
            null
        }
    }
}