package com.example.openweatherapp.data.remote.repository

import android.util.Log
import com.example.openweatherapp.data.remote.api.opencage.OpenCageService
import com.example.openweatherapp.data.remote.api.opencage.RetrofitOpenCageClient
import com.example.openweatherapp.data.model.OpenCageResponse
import com.example.openweatherapp.domain.repository.OpenCageRepository
import javax.inject.Inject

class OpenCageRepositoryImpl @Inject constructor() : OpenCageRepository {
    private val openCageService: OpenCageService = RetrofitOpenCageClient.openCageService

    override suspend fun getInformationOnLocation(longitude: Double, latitude: Double): OpenCageResponse? {
        return try {
            openCageService.getInformationOnLocation(latitudeAndLongitude = "$longitude+$latitude")
        } catch (e: Exception) {
            Log.d("Repository Call Failure | getCurrentWeather", "${e.cause} ${e.message}")
            null
        }
    }
}