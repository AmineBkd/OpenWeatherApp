package com.example.openweatherapp.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "weather_table")
data class WeatherEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val latitude: Double,
    val longitude: Double,
    val temperature: Double,
    val windSpeed: Double,
    val humidity: Double,
    val timestamp: Long,
    val timezone: String,
    val currentTime: String,
    val elevation: Double
)