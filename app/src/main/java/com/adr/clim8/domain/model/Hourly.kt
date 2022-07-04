package com.adr.clim8.domain.model

data class Hourly(
    val weather: List<SimpleWeather>,
    val temperature: Double,
    val feels_like: Double,
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val uvi: Double,
    val visibility: Int,
    val wind_deg: Int,
    val wind_gust: Double,
    val wind_speed: Double
)
