package com.example.composecatalog

import android.provider.CalendarContract.Colors
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButtonExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { Log.i("Bob", "Is Bottled watter asshole") },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Green
            ),
            border = BorderStroke(5.dp, Color.Black),
        ) {
            Text(text = "Bo'oh' o wa'er")
        }

    }
}

@Composable
fun MyButtonExample2() {
    var enable by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { enable = false },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Green
            ),
            border = BorderStroke(5.dp, Color.Black),
            enabled = enable
        ) {
            Text(text = "Bo'oh' o wa'er")
        }

    }
}
//Esto se usa en donde se llama la funcion, ejemplo el setContent
// var enable by rememberSaveable { mutableStateOf(true) }
//MyOutlinedButton2(enable, {enable = false})

@Composable
fun MyOutlinedButton2(enable:Boolean, isEnabled:(Boolean) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedButton(onClick = { isEnabled(enable) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.Green,
                disabledContainerColor = Color.Gray,
                disabledContentColor = Color.DarkGray
            ),
            enabled = enable
        ) {
            Text(text = "Push me asshole")
        }
    }
}