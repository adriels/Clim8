package com.adr.clim8.domain.model

data class DailyWeather(
    val day: String,
    val imageUrl: String,
    val weatherType: String,
    val maxTemperature: String,
    val minTemperature: String
)
