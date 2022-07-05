package com.adr.clim8.ui.presentation.screen.main

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.adr.clim8.ui.navigation.SetUpNavigation

@Composable
fun MainScreen(
    navController: NavHostController,
    mainViewModel: MainViewModel = hiltViewModel()
) {
    val permissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = {
            if (it) {
                val latLon = getLatLon(navController.context)
                mainViewModel.getLocalWeather(latLon.first, latLon.second)
            } else {
                navController.popBackStack()
            }
        }
    )

    if (ContextCompat.checkSelfPermission(
            navController.context,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) != PackageManager.PERMISSION_GRANTED
    ) {
        permissionResultLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
    }
}

private fun checkAndRequestPermission(onResult: () -> Unit) {}


@SuppressLint("MissingPermission")
private fun getLatLon(context: Context): Pair<String, String> {
    var latLon = Pair("", "")
    val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    locationManager.requestLocationUpdates(
        LocationManager.GPS_PROVIDER, 0, 0f
    ) {
        latLon = Pair(it.latitude.toString(), it.longitude.toString())
    }
    return latLon
}