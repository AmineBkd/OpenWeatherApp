package com.example.openweatherapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_cache")
data class WeatherEntity(
    @PrimaryKey
    val cityName: String,
    val cityId: Int,
    val timestamp: Long,
    val conditionMain: String,
    val conditionDescription: String,
    val conditionIcon: String,
    val temp: Double,
    val feelsLike: Double,
    val tempMin: Double,
    val tempMax: Double,
    val humidity: Int,
    val windSpeed: Double,
    val windDeg: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)