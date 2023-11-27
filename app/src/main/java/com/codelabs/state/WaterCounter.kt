package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            var showtask by remember { mutableStateOf(true) }
            if (showtask) {
                WellnessTaskItem(taskName = "¿Tas dao un paseillo por la plasa hoy primico?",
                    onClose = { showtask = false })
            }
        }
        if (count > 1) {
            Text(text = "Llevas $count medios de palo cortao.")
        } else if (count == 1) {
            Text(text = "Llevas $count medio de palo cortao.")
        }
        Row(modifier.padding(top = 8.dp)) {
            Button(onClick = { count++ }, Modifier.padding(), enabled = count < 10) {
                Text("Bebete otro rey")
            }
           // if(count>=1){
//                Button(onClick = { count = 0 }, Modifier.padding(start = 8.dp)) {
//                    Text(text = "Ya vale gachon que te van a coger los civiles")
//                }
           // }
        }
    }
}

@Composable
fun StatelessCounter(nombre: String,
                     count: Int,
                     onIncrement: () -> Unit,
                     modifier: Modifier= Modifier){
    Column(modifier= modifier.padding(16.dp)) {
        if(count > 0){
            if(count> 1)Text("Llevas $count vasos de $nombre.")
            else if(count == 1) Text(text = "Hoy llevas $count vasos de $nombre")
        }

        Row{
            Button(onClick = onIncrement,
                             Modifier.padding(top= 8.dp),
                             enabled= count< 10) {
                Text(text = "Tomate un $nombre primo")
            }
        }
    }
}
@Composable
fun AnotherStatelessMethod(nombre: String,
                           count: Int,
                           onIncrement: () -> Unit,
                           modifier: Modifier= Modifier){
    Column(modifier= modifier.padding(16.dp)) {
        if(count > 0){
            if(count> 1)Text("Llevas $count vasos de $nombre.")
            else if(count == 1) Text(text = "Hoy llevas $count vasos de $nombre")
        }

        Row{
            Button(onClick = onIncrement,
                Modifier.padding(top= 8.dp),
                enabled= count< 10) {
                Text(text = "Tomate un $nombre primo")
            }
        }
    }
}



@Composable
fun StatefulCounter(modifier: Modifier= Modifier){
    var vinecount by rememberSaveable { mutableStateOf(0)} // contador 1 para el vino
    var cubalibrecount by rememberSaveable { mutableStateOf(0)} // contador 2 para los cubalibres
    var nolotidcount by rememberSaveable { mutableStateOf(0)}
    Column {
            StatelessCounter("vino", vinecount, onIncrement= {vinecount++}) // llama al contador 1
            AnotherStatelessMethod(nombre = "vino", count = vinecount, onIncrement = { vinecount*=2 })
            StatelessCounter("cubalibre",cubalibrecount, onIncrement= {cubalibrecount++}) // llama al contador 2
            StatelessCounter("nolotid", nolotidcount,onIncrement={nolotidcount++})

    }
}
/*
@Composable
fun WellnessScreen(modifier: Modifier= Modifier){
    StatefulCounter(modifier)
}
*/
@Preview
@Composable
fun WaterCounterPreview(){
    WaterCounter()
}




















/*
@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        modifier = modifier
    )
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(
            onClick = onIncrement,
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Add one")
        }
    }
}
*/