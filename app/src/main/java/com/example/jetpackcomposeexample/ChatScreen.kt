package com.example.jetpackcomposeexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ChatScreen(navController: NavController, navigateToDetails: (String) -> Unit) {
    /*Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Chat Screen")
    }*/
    val scrollState = rememberScrollState()
    /*LazyColumn {
        itemsIndexed(listOf("this", "is", "jetpack", "compose")) { index, string ->

        }


    }*/
    LazyColumn {
        items(100) {
            Card(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                backgroundColor = Color.White,
                elevation = 10.dp
            ) {
                Row(modifier = Modifier.padding(all = 10.dp).clickable { navigateToDetails("Welcome to details screen") }) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_compose),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(8.dp)
                            .size(60.dp)
                            .clip(
                                CircleShape
                            )
                            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .fillMaxWidth()
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = "Person $it", style = typography.h6
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        Text(
                            text = "last message..",
                            style = typography.caption
                        )
                    }

                }
            }

        }
    }
}
