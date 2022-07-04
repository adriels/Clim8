package com.adr.clim8.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String?,
    val lat: String?,
    val lon: String?
) : Parcelable
