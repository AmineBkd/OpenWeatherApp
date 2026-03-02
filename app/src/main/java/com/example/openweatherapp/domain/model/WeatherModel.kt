package com.example.openweatherapp.domain.model

data class WeatherModel(
    val countryName: String,
    val cityName: String,
    val temperature: Double,
    val windSpeed: Double,
    val humidity: Double,
    val rain: Double,
    val precipitation: Double,
    val precipitationProbability: Int,
    val apparentTemperature: Double,
    val showers: Double,
    val snowfall: Double,
    val isDay: Int,
)