package com.example.composecatalog

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
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

//-----------------Cards----------------------
@Composable
fun MyCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Magenta, contentColor = Color.Green)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 1")
            Text(text = "Ejemplo 1")
        }
    }
}

//----------------BadgeBox ahora solo Badge----------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBadgeBox() {
    BadgedBox(modifier = Modifier
        .padding(16.dp),
        badge = {
            Text(text = "0")
        }) {
        Icon(Icons.Default.MailOutline, contentDescription = "")
    }
}

//---------------------Divider---------------------
@Composable
fun MyDivider() {
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    )
}

//------------------------- DopDown Menu-----------------------

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropDownMenu() {
    var selectedText by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var desserts = listOf("Helado", "Chocolate", "Cafe", "Fruta", "Natillas", "Chilaquiles")

    Column(modifier = Modifier.padding(20.dp)) {
        OutlinedTextField(
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = false,
            modifier = Modifier
                .clickable { expanded = true }
                .fillMaxWidth()
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            desserts.forEach { dessert ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedText = dessert
                    },
                    text = { Text(text = dessert) }
                )
            }
        }
    }
}

//---------------Slider-----------
@Composable
fun MySlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        Slider(value = sliderPosition, onValueChange = { sliderPosition = it })

        Text(text = sliderPosition.toString())

    }
}
@Composable
fun MyAdvancedSlider() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var sliderPosition by remember { mutableStateOf(0f) }
        var completeValue by remember { mutableStateOf(0f) }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            onValueChangeFinished = {completeValue = sliderPosition},
            valueRange = 0f..10f,
            steps = 9
            )

        Text(text = completeValue.toString())

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRangeSlider(){
    var currentRange by remember {mutableStateOf(0f..10f)}
    RangeSlider(
        value = currentRange,
        onValueChange = {currentRange = it},
        valueRange = 0f..10f,
        steps = 9
        )
    Text(text ="Valor inferior ${currentRange.start}")
    Text(text ="Valor inferior ${currentRange.endInclusive}")
}
