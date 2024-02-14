package com.example.composecatalog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun MySwich() {
    var state by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Switch(checked = state, onCheckedChange = { state = !state })
            Text(text = "Eres gay?")
        }
    }
}

@Composable
fun MyCheckBox() {
    var state by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Checkbox(
                checked = state,
                onCheckedChange = { state = !state },
                enabled = true,
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Red,
                    uncheckedColor = Color.Green,
                    checkmarkColor = Color.Blue
                )
            )
            Text(text = "Eres gay?")
        }
    }
}

//---------------------------------------------------------------------------------------------------
@Composable
fun getOptions(titles: List<String>): List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus }
        )
    }
}


@Composable
fun CheckBoxStateHoisting(checkInfo: CheckInfo) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(checked = checkInfo.selected,
            onCheckedChange = { checkInfo.onCheckedChange(!checkInfo.selected) })
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = checkInfo.title)

    }
}

@Composable
fun callCheckBoxList() {
    val myOptions = getOptions(listOf("Gay", "Hetero", "Berraco", "Transespecie"))
    Column {
        myOptions.forEach {
            CheckBoxStateHoisting(it)
        }
    }
}

@Composable
fun MyTriStatusCheckBox() {
    var status by rememberSaveable { mutableStateOf(ToggleableState.Off) }
    TriStateCheckbox(state = status, onClick = {
        status = when (status) {
            ToggleableState.On -> ToggleableState.Off
            ToggleableState.Off -> ToggleableState.Indeterminate
            ToggleableState.Indeterminate -> ToggleableState.On
        }
    }
    )
}

@Composable
fun MyRadioButton() {
    Row(modifier = Modifier.fillMaxWidth()) {
        var status by rememberSaveable { mutableStateOf(false) }
        RadioButton(selected = status,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green
            ),
            onClick = { status = !status })
    }
}

@Composable
fun MyRadioButtonList(selectedOption:String, onOptionSelected:(String) -> Unit) {
    Column(Modifier.fillMaxSize()) {
        Row {
            RadioButton(
                selected = selectedOption == "opcion 1",
                onClick = {onOptionSelected("opcion 1")}
            )
            Text(text = "Opcion 1")
        }
        Row {
            RadioButton(
                selected = selectedOption == "opcion 2",
                onClick = { onOptionSelected("opcion 2")}
            )
            Text(text = "Opcion 2")
        }
        Row {
            RadioButton(
                selected = selectedOption == "opcion 3",
                onClick = { onOptionSelected("opcion 3") }
            )
            Text(text = "Opcion 3")
        }
    }
}

@Composable
fun CallRadioButton(){
    var selected by rememberSaveable { mutableStateOf("")}
    MyRadioButtonList(selected) { selected = it }

}
