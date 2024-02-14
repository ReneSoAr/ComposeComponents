package com.example.composecatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
//Esto se usa donde se llama a la funcion, ejemplo en el setContent
//var name by remember{ mutableStateOf("") }
//EstateHoistingExample(name = name, onValueChanged = { name = it})

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EstateHoistingExample(name:String, onValueChanged:(String) -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Escribe aqui")

        TextField(value = name, onValueChange = {onValueChanged(it)})
    }
}