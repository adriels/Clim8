package com.adr.clim8.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.adr.clim8.ui.navigation.SetUpNavigation
import com.adr.clim8.ui.theme.Clim8Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Clim8Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    SetUpNavigation()
                }
            }
        }
    }
}