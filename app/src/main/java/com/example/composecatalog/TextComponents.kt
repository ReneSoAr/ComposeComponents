package com.example.composecatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

@Composable
fun MyText() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Ejemplo de un texto")
        Text(text = "Ejemplo de un texto con color", color = Color.Red)
        Text(text = "Ejemplo con texto Grueso", fontWeight = FontWeight.ExtraBold)
        Text(text = "Ejemplo de un texto delgado", fontWeight = FontWeight.Light)

        Text(
            text = "Ejemplo de texto tachado",
            style = TextStyle(textDecoration = TextDecoration.LineThrough)
        )

        Text(
            text = "Ejemplo de texto Subrayado",
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )

        Text(
            text = "Ejemplo de texto con decoracion combinada",
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(TextDecoration.Underline, TextDecoration.LineThrough)
                )
            )
        )

        Text(text = "Texto con el tamaño aumentado", fontSize = 19.sp)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Escribe aqui")

        var myText by remember { mutableStateOf("") }
        TextField(value = myText, onValueChange = { myText = it })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvanced() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Escribe aqui")

        var myText by remember { mutableStateOf("") }
        TextField(
            value = myText,
            onValueChange = {
                myText = if (it.contains("a")) {
                    it.replace("a", "")
                } else {
                    it
                }
            },
            label = { Text(text = "Introduce tu nombre") })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextfieldOutlined(){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Escribe aqui")

        var myText by remember { mutableStateOf("") }
        OutlinedTextField(value = myText, onValueChange = { myText = it }, label = { Text(text = "Holis")},
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color.LightGray,
                unfocusedBorderColor = Color.DarkGray
            )
            )
    }
}