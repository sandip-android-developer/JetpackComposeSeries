package com.example.jetpackcomposeexample

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    NavHost(navController = navController, startDestination = Screen.NavigationActivityOne.route) {
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
fun NavigationActivityOne(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 50.dp)
    ) {
        TextField(value = text, onValueChange = {
            text = it
        }, modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { navController.navigate(Screen.NavigationActivityTwo.withArgs(text)) },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text(text = "To Details Screen")
        }
    }
}

@Composable
fun NavigationActivityTwo(name: String) {
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Text(text = "Hello $name")

    }
}

@Composable
@Preview
fun PreviewOne()
{
    val navController = rememberNavController()
    NavigationActivityOne(navController)
}