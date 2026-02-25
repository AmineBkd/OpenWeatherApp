package com.example.openweatherapp.data.local

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather_cache WHERE cityName = :cityName LIMIT 1")
    fun observeWeather(cityName: String): Flow<WeatherEntity?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeather(entity: WeatherEntity): Long

    @Query("DELETE FROM weather_cache WHERE cityName = :cityName")
    fun deleteWeather(cityName: String)

    @Query("DELETE FROM weather_cache")
    fun clearAll()
}
