package com.example.jetpackcomposeexample

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavigationScreens(
    val name: String,
    val route: String,
    val icon: ImageVector,
    val badgeCount: Int = 0
) {
    object Home : BottomNavigationScreens("Home", "home", Icons.Default.Home)
    object Chat : BottomNavigationScreens("Chat", "chat", Icons.Default.Notifications)
    object Settings : BottomNavigationScreens("Settings", "settings", Icons.Default.Settings)
}
