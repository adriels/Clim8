package com.adr.clim8.data.repository

import com.adr.clim8.BuildConfig
import com.adr.clim8.data.service.api.Clim8Api
import com.adr.clim8.domain.model.Weather
import javax.inject.Inject
import com.adr.clim8.data.Result

class Clim8Repository @Inject constructor(private val api: Clim8Api) {

    suspend fun getWeather(
        lat: String,
        lon: String,
        exclude: String? = "minutely,alerts"
    ): Result<Weather> {
        val response = try {
            api.getWeather(
                lat = lat,
                lon = lon,
                exclude = exclude,
                appId = BuildConfig.WEATHER_API_KEY
            )
        } catch (e: Exception) {
            return Result.Error(e.message ?: "")
        }
        return Result.Success(response)
    }
}