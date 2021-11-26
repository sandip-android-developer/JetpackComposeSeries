package com.example.jetpackcomposeexample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings

sealed class Screen(val route: String) {
    object NavigationActivityOne : Screen("navigation_one")
    object NavigationActivityTwo : Screen("navigation_two")
    object SplashScreen : Screen("splash_screen")
    object MainScreen : Screen("main_screen")
    object Home : Screen("Home")
    object Chat : Screen("Chat")
    object Settings : Screen("Settings")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }
}
