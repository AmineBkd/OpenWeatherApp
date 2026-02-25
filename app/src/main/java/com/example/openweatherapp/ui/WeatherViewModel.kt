package com.example.openweatherapp.ui

/*import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.openweatherapp.data.local.WeatherEntity
import com.example.openweatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

data class WeatherUiState(
    val weather: WeatherEntity? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {

    private val _uiState = MutableStateFlow(WeatherUiState())
    val uiState: StateFlow<WeatherUiState> = _uiState.asStateFlow()

    private var currentCity: String? = null

    fun loadWeather(cityName: String, forceRefresh: Boolean = false) {
        currentCity = cityName

        // Observe the Room cache reactively
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
        }
    }

    fun retry() {
        currentCity?.let { loadWeather(it, forceRefresh = true) }
    }

    class Factory(private val repository: WeatherRepository) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(WeatherViewModel::class.java)) {
                return WeatherViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}*/