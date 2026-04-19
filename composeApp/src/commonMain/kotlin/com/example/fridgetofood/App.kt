package com.example.fridgetofood

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.fridgetofood.presentation.searchscreen.SearchViewModel
import org.koin.compose.koinInject

@Composable
@Preview
fun App(viewModel: SearchViewModel = koinInject()) {
    MaterialTheme {
        LaunchedEffect(Unit) {
            val recipes = viewModel.searchByQuery("pasta")
//            println("Recipes: ${recipes.map { it.title }}")
        }
        Text("Check logcat/console")
    }
}