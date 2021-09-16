package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Recyclerview : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scrollState = rememberScrollState()
            LazyColumn {
                //Two type we can load the data in LazyColumn
                //1.itemsIndexed ->its same as for each loop
                // 2.items->in this we have to give size then its load the data
                itemsIndexed(
                    listOf("this", "is", "jetpack", "compose")
                ) { index, string ->
                    Text(
                        text = "$string", fontSize = 24.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )
                }
                /* items(5000) {
                     Text(
                         text = "item $it", fontSize = 24.sp,
                         fontWeight = FontWeight.Light,
                         textAlign = TextAlign.Center,
                         modifier = Modifier
                             .fillMaxWidth()
                             .padding(vertical = 24.dp)
                     )
                 }*/
            }
            /*Column(modifier = Modifier.verticalScroll(scrollState)) {
                for (i in 1..50) {
                    Text(
                        text = "item $i", fontSize = 24.sp,
                        fontWeight = FontWeight.Light,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 24.dp)
                    )
                }
            }
*/
        }
    }
}