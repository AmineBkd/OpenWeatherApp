package com.example.openweatherapp.ui.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel

@Composable
fun WeatherScreen(
    viewModel: WeatherViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    Text(text = state.weather.toString())
}

@Composable
@Preview
private fun WeatherScreenPreview() {
    WeatherScreen()
}