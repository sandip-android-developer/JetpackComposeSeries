package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import kotlinx.coroutines.launch

class SideEffect : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val scope = rememberCoroutineScope()
            Scaffold(scaffoldState = scaffoldState) {
                var counter by remember {
                    mutableStateOf(0)
                }
                if (counter % 5 == 0 && counter > 0) {
                    /*scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }*/
                    LaunchedEffect(key1 =  scaffoldState.snackbarHostState)
                    {
                        scaffoldState.snackbarHostState.showSnackbar("Hello")
                    }

                }
                Button(onClick = { counter++ }) {
                    Text(text = "Click me : $counter")
                }

            }
        }
    }
}
