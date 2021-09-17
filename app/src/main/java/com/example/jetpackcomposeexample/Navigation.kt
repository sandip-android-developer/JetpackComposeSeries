package com.example.jetpackcomposeexample

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash_screen") {

        composable("splash_screen") {
            SplashScreen(navController = navController)
        }
        composable("main_screen")
        {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "MAIN SCREEN", color = Color.White)
            }
        }
        composable(route = Screen.NavigationActivityOne.route) {
            NavigationActivityOne(navController = navController)
        }
        composable(
            /*If we want to multiple value then we have to pass like /{name}/{age}/{rollno}*/
            //If we are passing option argument then write like  ?name={name} , if we are not passing anything
            //then it will take defaultValue.
            route = Screen.NavigationActivityTwo.route + "/{name}",
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
                defaultValue = "Sandip"
                nullable = true
            })
        ) { entry ->
            NavigationActivityTwo(name = entry.arguments?.getString("name")!!)
        }

    }
}




@Composable
@Preview
fun PreviewOne() {
    val navController = rememberNavController()
    NavigationActivityOne(navController)
}
