package com.adr.clim8.domain.model

data class HourlyWeather(
    val temperature: String,
    val imageUrl: String,
    val time: String,
    val maxTemperature: String,
    val minTemperature: String
)
