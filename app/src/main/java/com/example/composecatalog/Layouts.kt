package com.example.composecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyBox() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Hola cara de culo")

        }
    }
}

@Composable
fun MyColumn() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Cyan)
                .height(100.dp)

        ) {
            Text(text = "Hola cara de culo")
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Green)
                .height(100.dp)
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Push me")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Magenta)
                .height(100.dp)

        ) {
            Text(text = "Hola cara de pepino")

        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Red)
                .height(100.dp)

        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Push me")
            }
        }

    }

}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState()),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Cyan)
                .height(100.dp)

        ) {
            Text(text = "Hola cara de culo")
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Green)
                .height(100.dp)
        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Push me")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Magenta)
                .height(100.dp)

        ) {
            Text(text = "Hola cara de pepino")

        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.Red)
                .height(100.dp)

        ) {
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Push me")
            }
        }

    }

}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Dios mio no quiero trabajar")

        }
        EspacioVertical(size = 16)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .background(Color.Red)
                    .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Tengo mucha flojera")
            }
            EspacioHorizontal(size = 16)
            Box(modifier = Modifier
                .weight(1f)
                .background(Color.Green)
                .fillMaxHeight(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Quiero cagar")
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Estoy inflamado u.u")

        }
    }
}

@Composable
fun EspacioVertical (size:Int){
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun EspacioHorizontal(size:Int){
    Spacer(modifier = Modifier.width(size.dp))
}