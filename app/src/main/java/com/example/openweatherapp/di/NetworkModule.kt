package com.example.openweatherapp.di

import android.content.Context
import androidx.room.Room
import com.example.openweatherapp.data.local.WeatherDatabase
import com.example.openweatherapp.data.remote.api.openmeteo.RetrofitWeatherClient
import com.example.openweatherapp.data.remote.api.openmeteo.WeatherService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideWeatherService(): WeatherService {
        return RetrofitWeatherClient.weatherService
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): WeatherDatabase {
        return Room.databaseBuilder(
            context, WeatherDatabase::class.java, "weather_database"
        ).fallbackToDestructiveMigration().build()
    }
}