package com.example.openweatherapp.domain.model

data class WeatherModel(
    val countryName: String,
    val cityName: String,
    val temperature: Double,
    val windSpeed: Double,
    val humidity: Double,
)