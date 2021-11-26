package com.example.jetpackcomposeexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import com.example.jetpackcomposeexample.ui.theme.JetpackComposeExampleTheme

class ChatDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExampleTheme {
                Text(text = "$argsValue")
            }
        }
    }

    companion object {
        private const val ARGS_ID = "args_id"
        fun newIntent(context: Context, param: String) =
            Intent(context, ChatDetailsActivity::class.java).apply {
                putExtra(ARGS_ID, param)
            }
    }

    private val argsValue: String by lazy {
        intent?.getStringExtra(ARGS_ID) as String
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}