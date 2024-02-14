package com.example.composecatalog

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun MyImageExample(){
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Imagen de ejemplo",
            alpha = 0.5f)
        
    }
}

@Composable
fun MyImageAdvance(){
   Column(modifier = Modifier.fillMaxSize(),
       verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
       ) {
       Image(painter = painterResource(id = R.drawable.papafranku),
           contentDescription = "papa franku",
           modifier = Modifier
               .clip(CircleShape)
               .border(5.dp, Color.Black, CircleShape)
               //.clip(RoundedCornerShape(25f))
       )
       
       Text(text = "Papa Franku", fontWeight = FontWeight.Bold)
       Text(text = "its filthy frank mother fucker its filthy frank bitch")
   } 
}