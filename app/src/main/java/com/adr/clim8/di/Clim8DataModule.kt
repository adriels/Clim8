package com.adr.clim8.di

import com.adr.clim8.BuildConfig
import com.adr.clim8.data.repository.Clim8Repository
import com.adr.clim8.data.service.api.Clim8Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class Clim8DataModule {

    @Provides
    fun provideClim8Api(): Clim8Api =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.WEATHER_BASE_URL)
            .build()
            .create()

    @Provides
    fun provideClim8Repository(api: Clim8Api) = Clim8Repository(api)
}