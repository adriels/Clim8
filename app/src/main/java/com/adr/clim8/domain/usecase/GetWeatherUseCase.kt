package com.adr.clim8.domain.usecase

import com.adr.clim8.data.repository.Clim8Repository
import javax.inject.Inject

class GetLocalWeatherUseCase @Inject constructor(private val repository: Clim8Repository) {

    suspend operator fun invoke(lat: String, lon: String) = repository.getWeather(lat, lon)
}