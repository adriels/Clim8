package com.adr.clim8.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.adr.clim8.data.navigation.NavigationScreen
import com.adr.clim8.ui.presentation.screen.logIn.LogInScreen
import com.adr.clim8.ui.presentation.screen.main.MainScreen

@Composable
fun SetUpNavigation(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = NavigationScreen.LogIn.route) {
        composable(route = NavigationScreen.LogIn.route) {
            LogInScreen(navController)
        }
        composable(route = NavigationScreen.Main.route) {
            MainScreen(navController)
        }
    }
}