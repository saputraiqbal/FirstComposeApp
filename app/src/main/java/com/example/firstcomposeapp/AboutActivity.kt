package com.example.firstcomposeapp

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import com.example.firstcomposeapp.ui.theme.FirstComposeAppTheme

class AboutActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContent {
            FirstComposeAppTheme(darkTheme = true) {
                Scaffold(topBar = { MainAppBar() }) {
                    
                }
            }
        }
    }
}