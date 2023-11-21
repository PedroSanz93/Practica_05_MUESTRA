package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        StatefulCounter(modifier)
        WellnessTasksList()

        //WaterCounter()

//        WellnessTasksList(
//            list = wellnessViewModel.tasks,
//            onCheckedTask = { task, checked ->
//                wellnessViewModel.changeTaskChecked(task, checked)
//            },
//            onCloseTask = { task ->
//                wellnessViewModel.remove(task)
//            }
//        )
    }
}
