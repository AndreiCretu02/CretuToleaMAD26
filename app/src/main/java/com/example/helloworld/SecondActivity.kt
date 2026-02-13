package com.example.helloworld

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.unit.sp
import com.example.helloworld.ui.theme.HelloWorldTheme
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Box

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloWorldTheme {
                SecondScreen()
            }
        }
    }
}

@Composable
fun SecondScreen() {
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "History",
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
            Text(text = "Goal: This is the database. It allows the user to browse their entire concert life.\n" +
                    "\n" +
                    "View All: Displays a scrollable list of every single concert the user has ever attended.\n" +
                    "\n" +
                    "Search: Allows the user to type in an artist or venue name to find a specific past event.\n" +
                    "\n" +
                    "Filter: Lets the user sort the list (e.g., show only 5-star shows or only Festivals).\n" +
                    "\n" +
                    "Details: (Functionality for later) Clicking an item here would open the full memory (photos, notes).",
                modifier=Modifier.padding(32.dp),fontSize=25.sp)
            // Button to go back to Main
            Button(
                onClick = {
                    Log.d("MY_APP_TAG", "Button for MainActivity was clicked! Navigating to MainActivity...")
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Go to Main Activity")
            }

            // Button to go to Third
            Button(
                onClick = {
                    Log.d("MY_APP_TAG", "Button for ThirdActivity was clicked! Navigating to ThirdActivity...")
                    val intent = Intent(context, ThirdActivity::class.java)
                    context.startActivity(intent)
                },
                modifier = Modifier.padding(bottom = 50.dp) // Add some space at bottom
            ) {
                Text("Go to Third Activity")
            }
        }
    }
}