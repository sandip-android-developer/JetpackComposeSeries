package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import com.example.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class NavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                Scaffold{
                    Navigation() {
                        startActivity(BottomNavigation.newIntent(this, it))
                    }
                }

            }
        }
    }
}