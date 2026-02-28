package com.example.openweatherapp.di

import com.example.openweatherapp.data.local.WeatherDatabase
import com.example.openweatherapp.data.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideWeatherRepository(
        database: WeatherDatabase
    ) : WeatherRepository {
        return WeatherRepository(database)
    }
}