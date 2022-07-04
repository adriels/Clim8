package com.adr.clim8.domain.model

data class SimpleWeather(
    val id: Int,
    val main: String,
    val icon: String,
    val description: String
)
