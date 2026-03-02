package com.example.openweatherapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.domain.usecase.GetWeatherByLocation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val getWeatherByLocation: GetWeatherByLocation
) : ViewModel() {
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    //Default Location: France Paris
    fun loadWeather(
        latitude: Double = 48.85661,
        longitude: Double = 2.35222,
    ) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            val response = getWeatherByLocation.execute(latitude, longitude)
            if (response.isSuccess) {
                response.getOrNull()?.let { weather ->
                    _uiState.update {
                        it.copy(
                            countryName = weather.countryName,
                            cityName = weather.cityName,
                            temperature = weather.temperature,
                            windSpeed = weather.windSpeed,
                            humidity = weather.humidity,
                            isLoading = false,
                            error = null,
                        )
                    }
                } ?: _uiState.update {
                    it.copy(error = "General Error loading weather", isLoading = false)
                }
            } else if(response.isFailure) {
                _uiState.update {
                    it.copy(
                        error = response.exceptionOrNull()?.message ?: "General Error loading weather",
                        isLoading = false
                    )
                }
            }
        }
    }

    fun updateLocation(latitude: Double, longitude: Double) {
        _uiState.update { it.copy(currentMachineLocation = Pair(latitude, longitude)) }
    }
}