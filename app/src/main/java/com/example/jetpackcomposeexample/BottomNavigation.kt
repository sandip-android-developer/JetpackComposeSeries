package com.example.jetpackcomposeexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class BottomNavigation : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                MyApp{
                    startActivity(ChatDetailsActivity.newIntent(this,it))
                }
            }
        }
    }
    companion object {
        private const val ARGS_ID = "args_id"
        fun newIntent(context: Context, param: String) =
            Intent(context, BottomNavigation::class.java).apply {
                putExtra(ARGS_ID, param)
            }
    }

    private val argsValue: String by lazy {
        intent?.getStringExtra(ARGS_ID) as String
    }

}

@ExperimentalMaterialApi
@Composable
fun MyApp(navigateToDetails: (String) -> Unit) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavigationScreens.Home,
                    BottomNavigationScreens.Chat,
                    BottomNavigationScreens.Settings
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        BottomNav(navController = navController,navigateToDetails = navigateToDetails)
    }
}


@ExperimentalMaterialApi
@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationScreens>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavigationScreens) -> Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp
    ) {
        items.forEach { item ->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = Color.Green,
                unselectedContentColor = Color.Gray,
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        if (item.badgeCount > 0) {
                            BadgeBox(badgeContent = {
                                Text(text = item.badgeCount.toString())
                            }) {
                                Icon(imageVector = item.icon, contentDescription = item.name)
                            }
                        } else {
                            Icon(imageVector = item.icon, contentDescription = item.name)
                        }
                        if (selected) {
                            Text(text = item.name, textAlign = TextAlign.Center, fontSize = 10.sp)
                        }

                    }
                })
        }

    }
}

@Composable
fun BottomNav(navController: NavHostController,navigateToDetails: (String) -> Unit) {
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("chat") {
            ChatScreen(navController = navController,navigateToDetails =navigateToDetails )
        }
        composable("settings") {
            SettingScreen(navController = navController)
        }
    }

}

/*
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Home Screen")
    }
}

@Composable
fun ChatScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Chat Screen")
    }
}

@Composable
fun SettingsScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Text(text = "Settings Screen")
    }
}*/

