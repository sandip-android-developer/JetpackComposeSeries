package com.example.jetpackcomposeexample

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@Composable
fun NavigationActivityOne(navController: NavController, navigateToDashboard: (String) -> Unit) {
    var text by remember {
        mutableStateOf("")
    }
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(scaffoldState = scaffoldState) {
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
                onClick = /*{ navController.navigate(Screen.NavigationActivityTwo.withArgs(text)) }*/{
                    navigateToDashboard(
                        "Welcome to dashboard screen"
                    )
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Hello $text")
                    }
                },
                modifier = Modifier.align(Alignment.End),

                ) {
                Text(text = "To Details Screen")
            }
        }
    }
}