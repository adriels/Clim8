package com.adr.clim8.domain.model

data class Daily(
    val weather: List<SimpleWeather>,
    val temperature: Temperature,
    val feels_like: FeelsLike,
    val clouds: Int,
    val dew_point: Double,
    val dt: Int,
    val humidity: Int,
    val moon_phase: Double,
    val moonrise: Int,
    val moonset: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val sunrise: Int,
    val sunset: Int,
    val uvi: Double,
    val wind_deg: Int,
    val wind_gust: Double,
    val wind_speed: Double
)
