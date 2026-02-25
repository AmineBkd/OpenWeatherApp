package com.example.openweatherapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherData(
    @SerializedName("id")      val cityId: Int,
    @SerializedName("name")    val cityName: String,
    @SerializedName("dt")      val timestamp: Long,
    @SerializedName("weather") val conditions: List<WeatherCondition>,
    @SerializedName("main")    val main: MainMetrics,
    @SerializedName("wind")    val wind: Wind,
    @SerializedName("sys")     val sys: Sys
)

data class WeatherCondition(
    @SerializedName("id")          val id: Int,
    @SerializedName("main")        val main: String,
    @SerializedName("description") val description: String,
    @SerializedName("icon")        val icon: String
)

data class MainMetrics(
    @SerializedName("temp")       val temp: Double,
    @SerializedName("feels_like") val feelsLike: Double,
    @SerializedName("temp_min")   val tempMin: Double,
    @SerializedName("temp_max")   val tempMax: Double,
    @SerializedName("humidity")   val humidity: Int
)

data class Wind(
    @SerializedName("speed") val speed: Double,
    @SerializedName("deg")   val deg: Int
)

data class Sys(
    @SerializedName("country") val country: String,
    @SerializedName("sunrise") val sunrise: Long,
    @SerializedName("sunset")  val sunset: Long
)
