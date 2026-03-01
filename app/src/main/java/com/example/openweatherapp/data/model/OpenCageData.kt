package com.example.openweatherapp.data.model

import com.google.gson.annotations.SerializedName

data class OpenCageResponse(
    @SerializedName("documentation") val documentation: String,
    @SerializedName("licenses") val licenses: List<License>,
    @SerializedName("rate") val rate: Rate,
    @SerializedName("results") val results: List<Result>,
    @SerializedName("status") val status: Status,
    @SerializedName("stay_informed") val stayInformed: StayInformed,
    @SerializedName("thanks") val thanks: String,
    @SerializedName("timestamp") val timestamp: Timestamp,
    @SerializedName("total_results") val totalResults: Int
)

data class License(
    @SerializedName("name") val name: String,
    @SerializedName("url") val url: String
)

data class Rate(
    @SerializedName("limit") val limit: Int,
    @SerializedName("remaining") val remaining: Int,
    @SerializedName("reset") val reset: Long
)

data class Result(
    @SerializedName("bounds") val bounds: Bounds,
    @SerializedName("components") val components: Components,
    @SerializedName("confidence") val confidence: Int,
    @SerializedName("distance_from_q") val distanceFromQuery: DistanceFromQuery,
    @SerializedName("formatted") val formatted: String,
    @SerializedName("geometry") val geometry: Geometry
)

data class Bounds(
    @SerializedName("northeast") val northeast: Location,
    @SerializedName("southwest") val southwest: Location
)

data class Components(
    @SerializedName("ISO_3166-1_alpha-2") val isoAlpha2: String,
    @SerializedName("ISO_3166-1_alpha-3") val isoAlpha3: String,
    @SerializedName("ISO_3166-2") val isoAlpha2Region: List<String>,
    @SerializedName("_category") val category: String,
    @SerializedName("_normalized_city") val normalizedCity: String,
    @SerializedName("_type") val type: String,
    @SerializedName("borough") val borough: String?,
    @SerializedName("city") val city: String?,
    @SerializedName("continent") val continent: String,
    @SerializedName("country") val country: String?,
    @SerializedName("country_code") val countryCode: String,
    @SerializedName("house_number") val houseNumber: String?,
    @SerializedName("neighbourhood") val neighbourhood: String?,
    @SerializedName("office") val office: String?,
    @SerializedName("political_union") val politicalUnion: String?,
    @SerializedName("postcode") val postcode: String?,
    @SerializedName("quarter") val quarter: String?,
    @SerializedName("road") val road: String?,
    @SerializedName("state") val state: String,
    @SerializedName("state_code") val stateCode: String,
    @SerializedName("suburb") val suburb: String?
)

data class DistanceFromQuery(
    @SerializedName("meters") val meters: Int
)

data class Location(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
)

data class Geometry(
    @SerializedName("lat") val lat: Double,
    @SerializedName("lng") val lng: Double
)

data class Status(
    @SerializedName("code") val code: Int,
    @SerializedName("message") val message: String
)

data class StayInformed(
    @SerializedName("blog") val blog: String,
    @SerializedName("mastodon") val mastodon: String
)

data class Timestamp(
    @SerializedName("created_http") val createdHttp: String,
    @SerializedName("created_unix") val createdUnix: Long
)