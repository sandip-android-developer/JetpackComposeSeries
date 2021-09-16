package com.example.jetpackcomposeexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

class StyleText : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontFamily = FontFamily(
            Font(R.font.lexenddeca_thin, FontWeight.Thin),
            Font(R.font.lexenddeca_light, FontWeight.Light),
            Font(R.font.lexenddeca_regular, FontWeight.Normal),
            Font(R.font.lexenddeca_medium, FontWeight.Medium),
            Font(R.font.lexenddeca_semibold, FontWeight.SemiBold),
            Font(R.font.lexenddeca_bold, FontWeight.Bold),
            Font(R.font.lexenddeca_extrabold, FontWeight.ExtraBold),
            Font(R.font.lexenddeca_extralight, FontWeight.ExtraLight)
        )
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF101010))
            ) {
                Text(
                    //buildAnnotatedString is same as string builder
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 30.sp
                            )
                        ) {
                            append("J")
                        }
                        append("etpack ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.Green,
                                fontSize = 30.sp
                            )
                        ) {
                            append("c")
                        }
                        append("ompose ")
                    },
                    color = Color.White,
                    fontSize = 15.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}