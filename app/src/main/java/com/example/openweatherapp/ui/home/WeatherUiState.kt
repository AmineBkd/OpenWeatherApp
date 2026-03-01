package com.example.openweatherapp.ui.home

import com.example.openweatherapp.data.model.WeatherResponse

data class WeatherUiState(
    val countryName: String = "",
    val cityName: String = "",
    val temperature: Double = 0.0,
    val windSpeed: Double = 0.0,
    val humidity: Double = 0.0,
    val isLoading: Boolean = true,
    val error: String? = null,
)