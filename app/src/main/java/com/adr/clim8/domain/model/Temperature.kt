package com.adr.clim8.domain.model

data class Temperature(
    val day: Double,
    val eve: Double,
    val max: Double,
    val min: Double,
    val morn: Double,
    val night: Double
)
