package com.example.openweatherapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private var currentCity: String? = null

    fun loadWeather(cityName: String, forceRefresh: Boolean = false) {
        currentCity = cityName

        /*// Observe the Room cache reactively
        repository.observeWeather(cityName)
            .onEach { entity -> _uiState.update { it.copy(weather = entity) } }
            .launchIn(viewModelScope)

        // Trigger a network refresh when needed
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, error = null) }
            try {
                repository.refreshWeather(cityName, forceRefresh)
            } catch (e: Exception) {
                _uiState.update { it.copy(error = e.localizedMessage ?: "Unknown error") }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }*/
        viewModelScope.launch(Dispatchers.IO) {
            delay(5000)
            val response = repository.refreshWeather()
            with(Dispatchers.Main) {
                _uiState.update { it.copy(weather = response) }
            }
        }
    }
}