package com.example.openweatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherResponse(
    @SerializedName("latitude") val latitude: Double,
    @SerializedName("longitude") val longitude: Double,
    @SerializedName("generationtime_ms") val generationTimeMs: Double,
    @SerializedName("utc_offset_seconds") val utcOffsetSeconds: Int,
    @SerializedName("timezone") val timezone: String,
    @SerializedName("timezone_abbreviation") val timezoneAbbreviation: String,
    @SerializedName("elevation") val elevation: Double,
    @SerializedName("current_units") val currentUnits: CurrentUnits,
    @SerializedName("current") val current: CurrentWeather,
    @SerializedName("hourly_units") val hourlyUnits: HourlyUnits,
    @SerializedName("hourly") val hourly: HourlyData
)

data class CurrentUnits(
    @SerializedName("time") val time: String,
    @SerializedName("interval") val interval: String,
    @SerializedName("temperature_2m") val temperature2m: String,
    @SerializedName("wind_speed_10m") val windSpeed10m: String
)

data class CurrentWeather(
    @SerializedName("time") val time: String,
    @SerializedName("interval") val interval: Int,
    @SerializedName("temperature_2m") val temperature2m: Double,
    @SerializedName("wind_speed_10m") val windSpeed10m: Double,
    @SerializedName("relative_humidity_2m") val relativeHumidity2m: Double,
    @SerializedName("rain") val rain: Double,
    @SerializedName("precipitation") val precipitation: Double,
    @SerializedName("precipitation_probability") val precipitationProbability: Int,
    @SerializedName("apparent_temperature") val apparentTemperature: Double,
    @SerializedName("showers") val showers: Double,
    @SerializedName("snowfall") val snowfall: Double,
    @SerializedName("is_day") val isDay: Int,
)

data class HourlyUnits(
    @SerializedName("time") val time: String,
    @SerializedName("temperature_2m") val temperature2m: String,
    @SerializedName("relative_humidity_2m") val relativeHumidity2m: String,
    @SerializedName("wind_speed_10m") val windSpeed10m: String
)

data class HourlyData(
    @SerializedName("time") val time: List<String>,
    @SerializedName("temperature_2m") val temperature2m: List<Double>,
    @SerializedName("relative_humidity_2m") val relativeHumidity2m: List<Double>,
    @SerializedName("wind_speed_10m") val windSpeed10m: List<Double>
)