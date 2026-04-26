package com.example.fridgetofood.presentation.screens.tryitscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject

@Composable
fun TryItScreen(
    modifier: Modifier,
    onRecipeClick: (String) -> Unit,
    viewModel: TryItViewModel = koinInject(),
) {

    val state by viewModel.state.collectAsState()

}