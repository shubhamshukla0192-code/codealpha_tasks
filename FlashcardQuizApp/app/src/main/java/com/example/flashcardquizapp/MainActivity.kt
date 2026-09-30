package com.example.flashcardquizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            FlashcardQuizApp()
        }
    }
}

@Composable
fun FlashcardQuizApp() {

    val questions = listOf(
        "What is HTML?" to "HTML stands for HyperText Markup Language.",
        "What is CSS?" to "CSS is used to style and design web pages.",
        "What is Kotlin?" to "Kotlin is a modern programming language used for Android development.",
        "What is Android?" to "Android is a mobile operating system developed by Google."
    )

    var currentQuestion by remember { mutableStateOf(0) }
    var showAnswer by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Flashcard Quiz",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = if (showAnswer)
                questions[currentQuestion].second
            else
                questions[currentQuestion].first,
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                showAnswer = !showAnswer
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (showAnswer) "Show Question" else "Show Answer"
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                currentQuestion =
                    (currentQuestion + 1) % questions.size
                showAnswer = false
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }
    }
}