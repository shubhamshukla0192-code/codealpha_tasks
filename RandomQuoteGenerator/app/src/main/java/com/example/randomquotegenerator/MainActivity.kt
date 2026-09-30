package com.example.randomquotegenerator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            RandomQuoteApp()
        }
    }
}

@Composable
fun RandomQuoteApp() {

    val quotes = listOf(
        "Believe in yourself and keep moving forward.",
        "Success comes from consistent effort.",
        "Every day is a new opportunity to learn.",
        "Don't stop until you are proud.",
        "Small steps every day lead to big results.",
        "Your future depends on what you do today."
    )

    var currentQuote by remember {
        mutableStateOf(quotes[0])
    }

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Random Quote",
                fontSize = 30.sp
            )

            Text(
                text = currentQuote,
                fontSize = 20.sp,
                modifier = Modifier.padding(30.dp)
            )

            Button(
                onClick = {
                    currentQuote = quotes.random()
                }
            ) {
                Text(text = "New Quote")
            }
        }
    }
}