package com.adr.clim8.data.service.api

import com.adr.clim8.domain.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface Clim8Api {
    @GET("/data/3.0/onecall?")
    suspend fun getWeather(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("exclude") exclude: String?,
        @Query("appid") appId: String
    ): Weather
}