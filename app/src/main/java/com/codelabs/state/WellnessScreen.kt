package com.codelabs.state

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

private fun getWellnessTasks() = List(30){i -> WellnessTask(i,"Task #$i")}
@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier) {

        Column(modifier= modifier) {
            StatefulCounter(modifier)

            }
            val list= remember{
                getWellnessTasks().toMutableStateList()
        }

        WellnessTasksList(list = list,
                          onCloseTask = {task -> list.remove(task)})

}



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
