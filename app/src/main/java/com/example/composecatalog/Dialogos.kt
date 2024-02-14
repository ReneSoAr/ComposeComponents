package com.example.composecatalog

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties

//-------------AlertDialog-------------
@Composable
fun MyDialog(
    show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(onDismissRequest = { onDismiss() },
            title = { Text(text = "Has sido hakeado") },
            text = { Text(text = "Por ser un cochinote has sido hakeado") },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "Confirm")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Rechazar")
                }
            })
    }
}

@Composable
fun showDialog() {
    var show by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center
    ) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar Dialogo")
        }
    }
    MyDialog(show = show, onDismiss = { show = false }, onConfirm = { Log.i("Mensaje", "Click") })

}
//--------------------------dialog-----------------------

@Composable
fun MySimpleCustomDialog(
    show: Boolean, onDissmiss: () -> Unit
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDissmiss() },
            properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un ejemplo del Dialog")

            }
        }
    }
}

@Composable
fun CallDialog() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var show by remember { mutableStateOf(false) }
        Button(onClick = { show = true }) {
            Text(text = "Press")
        }
        MySimpleCustomDialog(show = show) { show = false }
    }
}

//-------------------------------------------------
@Composable
fun MyCustomDialog(
    show: Boolean, onDismiss: () -> Unit
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss }) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()

            ) {
                MyTitleDialog(titleText = "Set backup account")
                AccountItem(email = "rjsa@gmail.com", drawable = R.drawable.papafranku)
                AccountItem(email = "Dicklover@gmail.com", drawable = R.drawable.papafranku)
                AccountItem(
                    email = "Añadir nueva cuenta",
                    drawable = R.drawable.ic_launcher_background
                )
            }

        }
    }

}

@Composable
fun CallMyCustomDialog() {
    Column(
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var show by remember { mutableStateOf(true) }
        MyCustomDialog(show = show) { show = false }
    }
}

@Composable
fun MyTitleDialog(titleText: String, modifier:Modifier = Modifier) {
    Text(
        text = titleText,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )

}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "Avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )

        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

//----------------------Dialogos de confirmacion------------
@Composable
fun MyConfirmationDialog(show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss }) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                MyTitleDialog(titleText = "Phone ringtone", Modifier.padding(24.dp))
                Divider(Modifier.fillMaxWidth())
                RingtoneList()
                Divider(Modifier.fillMaxWidth())
                Row(Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Cancel")
                    }
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Ok")
                    }
                }
            }
        }
    }
}

@Composable
fun RingtoneList() {
    var selected by remember { mutableStateOf("") }
    Column(
        Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(Modifier.padding(6.dp)) {
            RadioButton(
                selected = selected == "None",
                onClick = { selected = "None" }
            )
            Text(text = "None")
        }
        Row(Modifier.padding(6.dp)) {
            RadioButton(selected = selected == "Calisto",
                onClick = { selected = "Calisto" }
            )
            Text(text = "Calisto")
        }
        Row(Modifier.padding(6.dp)) {
            RadioButton(selected = selected == "Ganymede",
                onClick = { selected = "Ganymede" }
            )
            Text(text = "Ganymede")
        }
        Row(Modifier.padding(6.dp)) {
            RadioButton(selected = selected == "Luna",
                onClick = { selected = "Luna" }
            )
            Text(text = "Luna")
        }

    }
}

@Composable
fun CallMyConfirmationDialog(){
    var show by remember {mutableStateOf(true)}
    MyConfirmationDialog(show = show) {show = false}
}