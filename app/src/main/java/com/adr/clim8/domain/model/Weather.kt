package com.adr.clim8.domain.model

data class Weather(
    val lat: String,
    val lon: String,
    val current: Current,
    val daily: List<Daily>,
    val hourly: List<Hourly>,
    val timezone: String,
    val timezone_offset: Int
)