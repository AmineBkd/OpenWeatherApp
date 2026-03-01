package com.example.openweatherapp.domain.repository

import com.example.openweatherapp.data.model.OpenCageResponse

interface OpenCageRepository {
    suspend fun getInformationOnLocation(longitude: Double, latitude: Double): OpenCageResponse?
}