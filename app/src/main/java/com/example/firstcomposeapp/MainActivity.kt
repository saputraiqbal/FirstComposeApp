package com.example.firstcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstcomposeapp.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var customBackground: Color by remember {
                mutableStateOf(Purple500)
            }
            val itemList = listOf(
                Pair("Teal", Teal200),
                Pair("Fluorescent Purple", Purple200),
                Pair("Bluish Purple", Purple700)
            )

            FirstComposeAppTheme(
                darkTheme = true
            ) {
                Scaffold(
                    topBar = { MainAppBar() },
                    backgroundColor = customBackground,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp),
                    ) {
                        LazyColumn {
                            items(itemList) { item ->
                                ComposeItemList(data = item) {
                                    customBackground = item.second
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(24.dp))
                        MainButton()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewApp() {
    FirstComposeAppTheme(
        darkTheme = true
    ) {
        Scaffold(
            topBar = { MainAppBar() },
            backgroundColor = Teal200,
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp)
            ) {
                LazyColumn(
                ) {
                    item {
                        ComposeItemList(data = Pair("Example", Teal200)) {  }
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                MainButton()
            }
        }
    }
}

@Composable
fun MainAppBar() {
    TopAppBar (
       title = { Text(text = "First Compose App") },
       modifier = Modifier.height(72.dp),
    )
}

@Composable
fun ComposeItemList(data: Pair<String, Color>, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight()
            .clickable { onClick.invoke() }
    ) {
        Text(
            text = data.first,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MainButton() {
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onBackground),
        onClick = {  }
    ) {
        Text(text = "About Me")
    }
}