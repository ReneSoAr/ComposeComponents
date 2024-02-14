package com.example.composecatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun MyStateExample(){
    var counter by rememberSaveable { mutableStateOf(0) }//Variable de estado mutable que mantiene su valor incluso despues de la recomposicion


    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,//Centra de arriba a abajo
        horizontalAlignment = Alignment.CenterHorizontally//Centra de izquierda a derecha
        ) {
        Button(onClick = { counter += 1}) {
            Text(text = "Pulsar")
        }
        Text(text = "He sido pulsado $counter veces")
    }
}