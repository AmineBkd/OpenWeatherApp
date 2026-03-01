package com.example.openweatherapp.data.remote.api.opencage

import com.example.openweatherapp.data.model.OpenCageResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenCageService {
    companion object {
        const val BASE_URL = "https://api.opencagedata.com"
    }

    @GET("geocode/v1/json")
    suspend fun getInformationOnLocation(
        @Query("key") apiKey: String = "", //Insert OpenCageDate Api Key here for the time being
        @Query("q") latitudeAndLongitude: String,
        @Query("no_annotation") annotation: String = "1",
    ) : OpenCageResponse
}