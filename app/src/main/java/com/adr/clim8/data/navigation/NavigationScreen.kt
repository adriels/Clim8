package com.adr.clim8.data.navigation

sealed class NavigationScreen(val route: String) {
    object LogIn : NavigationScreen(route = "logIn")
    object Main : NavigationScreen(route = "main")
}
