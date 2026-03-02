package com.example.openweatherapp.domain.usecase

import com.example.openweatherapp.data.remote.repository.OpenCageRepositoryImpl
import com.example.openweatherapp.data.remote.repository.WeatherRepositoryImpl
import com.example.openweatherapp.domain.model.WeatherModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.Double

class GetWeatherByLocation @Inject constructor(
    private val weatherRepositoryImpl: WeatherRepositoryImpl,
    private val openCageRepositoryImpl: OpenCageRepositoryImpl,
) {
    suspend fun execute(latitude: Double, longitude: Double): Result<WeatherModel> {
        return withContext(Dispatchers.IO) {
            val weatherResponse = weatherRepositoryImpl.getWeather(latitude = latitude, longitude = longitude)?.current
            val countryInformation = openCageRepositoryImpl.getInformationOnLocation(latitude, longitude)?.results?.getOrNull(0)?.components
            if(weatherResponse != null && countryInformation != null) {
                Result.success(
                    WeatherModel(
                        countryName = countryInformation.country ?: countryInformation.category,
                        cityName = countryInformation.city ?: "",
                        temperature = weatherResponse.temperature2m,
                        windSpeed = weatherResponse.windSpeed10m,
                        humidity = weatherResponse.relativeHumidity2m,
                        rain = weatherResponse.rain,
                        precipitation = weatherResponse.precipitation,
                        precipitationProbability = weatherResponse.precipitationProbability,
                        apparentTemperature = weatherResponse.apparentTemperature,
                        showers = weatherResponse.showers,
                        snowfall = weatherResponse.snowfall,
                        isDay = weatherResponse.isDay,
                    )
                )
            } else {
                Result.failure(Exception("Error loading weather"))
            }
        }
    }
}