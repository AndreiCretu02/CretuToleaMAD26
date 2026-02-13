package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import android.util.Log
import com.example.helloworld.ui.theme.HelloWorldTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                ThirdScreen()
            }
        }
    }
}

@Composable
fun ThirdScreen() {
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "Profile",
                modifier = Modifier.align(Alignment.TopStart).padding(bottom = 32.dp).padding(top = 32.dp).padding(horizontal = 32.dp),fontSize = 30.sp
            )
        }
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text="Goal: This is the summary. It gamifies the experience by showing stats.\n" +
                    "\n" +
                    "User Identity: Shows the user's name and photo.\n" +
                    "\n" +
                    "High-Level Stats: Displays total counts (e.g., \"42 Concerts Total\") to give a sense of accomplishment.\n" +
                    "\n" +
                    "Top Lists: Ranks the user's most-seen artists (e.g., \"You've seen Foo Fighters 5 times\").\n" +
                    "\n" +
                    "Settings: Provides a place to log out or manage account details.",
                modifier=Modifier.padding(32.dp), fontSize = 25.sp)
            Button(
                onClick = {
                    Log.d("MY_APP_TAG", "Button for SecondActivity was clicked! Navigating to SecondActivity...")
                    val intent = Intent(context, SecondActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.padding(bottom = 50.dp).padding(top = 50.dp)
            ) {
                Text("Go to Second Activity")
            }
        }
    }
}