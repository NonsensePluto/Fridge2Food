package com.example.fridgetofood

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.fridgetofood.data.remote.api.SpoonacularApi
import org.koin.compose.koinInject

@Composable
@Preview
fun App(api: SpoonacularApi = koinInject()) {
    MaterialTheme {
        LaunchedEffect(Unit) {
            val recipes = api.complexSearch("pasta")
            println("Recipes: ${recipes.recipes.map { it.title }}")
        }
        Text("Check logcat/console")
    }
}