package com.example.composecatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressBar() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 3.dp)
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 32.dp),
            trackColor = Color.DarkGray
        )
    }
}

@Composable
fun MyProgressBarAdvance() {
    var progress by remember { mutableStateOf(0f) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LinearProgressIndicator(progress = progress)
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {if (progress in 0f..1f){ progress += 0.1f} else{""}}) {
                Text(text = "Aumentar")
            }

            Button(onClick = {if (progress in 0f..1f){progress -= 0.1f}else{""}}) {
                Text(text = "Reducir")
            }

        }
    }

}

@Composable
fun showProgress(){
    var showloading by remember { mutableStateOf(false) }
    
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        if (showloading){
            CircularProgressIndicator()
        }
        
        Button(onClick = {showloading =!showloading }) {
            Text(text = "Cargar perfil")
        }
    }
}
