package com.example.openweatherapp.data.repository

/*
import com.example.openweatherapp.data.local.WeatherDao
import com.example.openweatherapp.data.local.WeatherEntity
import com.example.openweatherapp.data.model.WeatherData
import com.example.openweatherapp.data.remote.WeatherService
import kotlinx.coroutines.flow.Flow

class WeatherRepository(
    private val weatherService: WeatherService,
    private val weatherDao: WeatherDao,
    private val apiKey: String
) {

    fun observeWeather(cityName: String): Flow<WeatherEntity?> =
        weatherDao.observeWeather(cityName)

    suspend fun refreshWeather(cityName: String, forceRefresh: Boolean = false): WeatherData {
        if (!forceRefresh) {
            val cached = weatherDao.getWeather(cityName)
            if (cached != null && !isStale(cached.timestamp)) {
                return cached.toWeatherData()
            }
        }

        val remote = weatherService.getCurrentWeather(cityName, apiKey)
        weatherDao.insertWeather(remote.toEntity())
        return remote
    }

    private fun isStale(timestampSeconds: Long): Boolean {
        val ageMs = System.currentTimeMillis() - timestampSeconds * 1_000
        return ageMs > CACHE_TTL_MS
    }

    companion object {
        private const val CACHE_TTL_MS = 10 * 60 * 1_000L  // 10 minutes
    }
}

// ── Mapping helpers ──────────────────────────────────────────────────

fun WeatherData.toEntity(): WeatherEntity {
    val condition = conditions.first()
    return WeatherEntity(
        cityName = cityName,
        cityId = cityId,
        timestamp = timestamp,
        conditionMain = condition.main,
        conditionDescription = condition.description,
        conditionIcon = condition.icon,
        temp = main.temp,
        feelsLike = main.feelsLike,
        tempMin = main.tempMin,
        tempMax = main.tempMax,
        humidity = main.humidity,
        windSpeed = wind.speed,
        windDeg = wind.deg,
        country = sys.country,
        sunrise = sys.sunrise,
        sunset = sys.sunset
    )
}

fun WeatherEntity.toWeatherData(): WeatherData {
    return WeatherData(
        cityId = cityId,
        cityName = cityName,
        timestamp = timestamp,
        conditions = listOf(
            com.example.openweatherapp.data.model.WeatherCondition(
                id = 0,
                main = conditionMain,
                description = conditionDescription,
                icon = conditionIcon
            )
        ),
        main = com.example.openweatherapp.data.model.MainMetrics(
            temp = temp,
            feelsLike = feelsLike,
            tempMin = tempMin,
            tempMax = tempMax,
            humidity = humidity
        ),
        wind = com.example.openweatherapp.data.model.Wind(
            speed = windSpeed,
            deg = windDeg
        ),
        sys = com.example.openweatherapp.data.model.Sys(
            country = country,
            sunrise = sunrise,
            sunset = sunset
        )
    )
}
*/