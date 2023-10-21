package com.example.android_demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.android_demo.main.LoginPage
import com.example.android_demo.main.MainNavigation
import com.example.android_demo.ui.theme.Android_DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Android_DemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainApp()
                }
            }
        }
    }

    @Composable
    fun MainApp() {
        MainNavigation()
    }


    data class Task(val id: Int, val text: String)

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TodoApp() {
        var tasks by remember { mutableStateOf(mutableStateListOf<Task>()) }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "TODO List",
                color = MaterialTheme.colorScheme.tertiary,
                style = MaterialTheme.typography.displayLarge,
                fontWeight = FontWeight.Bold
            )

            TodoForm(
                onAddTask = { text ->
                    tasks.add(Task(tasks.size + 1, text))
                }
            )

            TodoList(
                tasks = tasks,
                onDeleteTask = { id ->
                    tasks.removeIf { it.id == id }
                }
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun TodoForm(onAddTask: (String) -> Unit) {
        var taskText by remember { mutableStateOf("") }

        Row(
            modifier = Modifier.padding(vertical = 24.dp)
        ) {
            TextField(
                value = taskText,
                onValueChange = { taskText = it },
                singleLine = true,
                placeholder = {
                    Text("Enter Task")
                }
            )
            Button(
                onClick = {
                    if (taskText.isNotBlank()) {
                        onAddTask(taskText)

                    }
                },
                shape = MaterialTheme.shapes.small,
            ) {
                Text(
                    text = "Add Todo",
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }

    @Composable
    fun TodoList(tasks: List<Task>, onDeleteTask: (Int) -> Unit) {
        Box(
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .size(500.dp)
                .border(5.dp, Color.White)
                .padding(2.dp)
        ) {
            LazyColumn() {
                items(tasks) { task ->
                    TodoItem(
                        task = task,
                        onDeleteTask = onDeleteTask
                    )
                }
            }
        }
    }

    @Composable
    fun TodoItem(task: Task, onDeleteTask: (Int) -> Unit) {
        val checkedState = rememberSaveable { mutableStateOf(false) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { isChecked ->
                    checkedState.value = isChecked
                },
                modifier = Modifier.padding(end = 16.dp)
            )
            Text(
                text = task.text,
                style = MaterialTheme.typography.titleSmall.copy(
                    textDecoration = if (checkedState.value) TextDecoration.LineThrough else TextDecoration.None
                ),
                modifier = Modifier.padding(18.dp)
            )
            Button(
                onClick = {
                    onDeleteTask(task.id)
                },
                shape = MaterialTheme.shapes.small,
            ) {
                Text(
                    text = "Delete",
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold
                )
            }
        }
    }
}


