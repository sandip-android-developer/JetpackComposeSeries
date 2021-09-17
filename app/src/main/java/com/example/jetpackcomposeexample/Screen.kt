package com.example.jetpackcomposeexample

sealed class Screen(val route: String) {
    object NavigationActivityOne : Screen("navigation_one")
    object NavigationActivityTwo : Screen("navigation_two")
    object SplashScreen : Screen("splash_screen")
    object MainScreen : Screen("main_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { args ->
                append("/$args")
            }
        }
    }
}
