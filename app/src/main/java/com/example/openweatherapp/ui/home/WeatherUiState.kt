package com.example.openweatherapp.ui.home

import com.example.openweatherapp.model.WeatherResponse

data class WeatherUiState(
    val weather: WeatherResponse? = null,
    val isLoading: Boolean = false,
    val error: String? = null,
)