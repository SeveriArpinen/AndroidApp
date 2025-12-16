package com.example.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidapp.ui.theme.AndroidAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidAppTheme {
                TodoView()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun TodoView() {
    val todos = remember {
        mutableStateListOf(
            Todo("test"),
            Todo("AAAAAAAAAAA")
        )
    }

    var newTodo by remember {mutableStateOf("")}

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "My list of Todos!",
            fontSize = 20.sp,

        )
        TextField(

            value = newTodo,
            label = {
                Text("Enter a new TODO")
            },
            onValueChange = {newTodo = it}
        )
        Button(
            onClick = {
                todos.add(
                    Todo(
                        newTodo
                    )
                )
                newTodo = ""
            },
            modifier = Modifier
                .padding(10.dp)
        ) {
            Text ("Add a new task")
        }
        if (todos.isEmpty()){
            Text (
                text = "No todos yet, add your first!",
                modifier = Modifier
                    .padding(10.dp)
            )
        } else {
            for (todo in todos) {
                Text(
                    text = todo.todo,
                    modifier = Modifier
                        .padding(10.dp)
                )
            }
        }

    }


}