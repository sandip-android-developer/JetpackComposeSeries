package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //TextList()
            val painter = painterResource(id = R.drawable.snowman)
            val description = "Kernit the snow"
            val title = "kernit is playing in the snow"

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(16.dp)
            ) {
                ImageCard(painter = painter, contextDescription = description, title = title)
            }
        }
    }

    @Composable
    private fun TextList() {
        Column(
            modifier = Modifier
                //  .width(600.dp)
                //.requiredWidth(600.dp)
                .background(color = Color.Green)
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .border(width = 5.dp, color = Color.Magenta)
                .padding(5.dp)
                .border(width = 5.dp, color = Color.Blue)
                .padding(5.dp)
                .border(width = 5.dp, color = Color.Red)
                .padding(10.dp)

        ) {
            Text(text = "Hello", modifier = Modifier.clickable { })
            Spacer(modifier = Modifier.height(50.dp))
            Text(text = "world")
        }
    }

    @Preview
    @Composable
    fun PreviewText() {
        TextList()
    }
}

@Composable
fun ImageCard(
    painter: Painter,
    contextDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp))
        {
            Image(
                painter = painter,
                contentDescription = contextDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ), startY = 300f
                        )
                    )
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),verticalArrangement = Arrangement.Bottom
            )
            {
                Text(text = contextDescription, style = TextStyle(color = Color.White, fontSize = 16.sp))
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}
