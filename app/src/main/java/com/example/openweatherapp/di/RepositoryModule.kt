package com.example.openweatherapp.di

import com.example.openweatherapp.data.local.WeatherDatabase
import com.example.openweatherapp.data.remote.repository.WeatherRepositoryImpl
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
    ) : WeatherRepositoryImpl {
        return WeatherRepositoryImpl(database)
    }
}