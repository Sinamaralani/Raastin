package com.example.raastin.core.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.raastin.core.presentation.navigation.Navigation
import com.example.raastin.core.presentation.theme.RaastinTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        installSplashScreen()
        setContent {
            RaastinTheme {
                Navigation()
            }
        }
    }
}