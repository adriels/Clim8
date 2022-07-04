package com.adr.clim8.ui.presentation.screen.main

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adr.clim8.data.Result
import com.adr.clim8.data.dispatcher.CoroutineDispatcherProvider
import com.adr.clim8.domain.model.HourlyWeather
import com.adr.clim8.domain.usecase.GetLocalWeatherUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val coroutineDispatcher: CoroutineDispatcherProvider,
    private val getLocalWeatherUseCase: GetLocalWeatherUseCase
) : ViewModel() {

    var hourlyWeatherList = mutableStateOf<List<HourlyWeather>>(listOf())
    var isLoading = mutableStateOf(false)
    var loadError = mutableStateOf("")
    var currentDate = mutableStateOf("")
    var currentWeatherType = mutableStateOf("")
    var currentTemp = mutableStateOf("")
    var currentImgUrl = mutableStateOf("")
    var currentHumidity = mutableStateOf("")
    var currentUV = mutableStateOf("")

    fun getLocalWeather(lat: String, lon: String) =
        viewModelScope.launch(coroutineDispatcher.default) {
            when (val result = getLocalWeatherUseCase(lat, lon)) {
                is Result.Success -> {
                    result.data?.let {
                        // currentDate.value = getFormattedDate(it.current.dt)
                        currentWeatherType.value = it.current.weather.first().main
                        // currentTemp.value = getTemperatureInCelsius(it.current.temperature)
                        currentImgUrl.value = it.current.weather.first().icon
                        // currentHumidity.value = getHumidityInPercent(it.current.humidity)
                        // currentUV.value = getFormattedUVRange(it.current.uvi)
                    }
                }
                is Result.Error -> {
                    result.message?.let {
                        loadError.value = it
                        isLoading.value = false
                    }
                }
            }
        }
}