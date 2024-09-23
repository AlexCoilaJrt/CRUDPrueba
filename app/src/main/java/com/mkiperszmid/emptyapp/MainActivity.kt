package com.mkiperszmid.emptyapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.mkiperszmid.emptyapp.home.HomeScreen
import com.mkiperszmid.emptyapp.home.HomeViewModel
import com.mkiperszmid.emptyapp.home.ProductService
import com.mkiperszmid.emptyapp.home.StudentService
import com.mkiperszmid.emptyapp.home.StudentViewModel
import com.mkiperszmid.emptyapp.ui.theme.EmptyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EmptyAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Asegúrate de que estás usando StudentViewModel
                    val viewModel = StudentViewModel(StudentService.instance)
                    HomeScreen(viewModel) // Asegúrate de que HomeScreen acepta StudentViewModel
                }
            }
        }
    }
}