package com.codelabs.state

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

private fun getWellnessTasks()= List(30) {i -> WellnessTask(i,"Task #$i")}

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items= list,
              key= {task -> task.id})
        { task ->
            WellnessTaskItem(taskName = task.label,
                             onClose= {onCloseTask(task)})
        }
    }
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier)
{
    var checkedState by rememberSaveable { mutableStateOf(false)}
    WellnessTaskItem(taskName = taskName,
                     checked = checkedState,
                     onCheckedChange = {newValue -> checkedState = newValue},
                     onClose = onClose,
                     modifier = modifier)
}
