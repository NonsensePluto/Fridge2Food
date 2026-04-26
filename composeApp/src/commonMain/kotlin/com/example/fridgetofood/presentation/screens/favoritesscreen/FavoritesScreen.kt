package com.example.fridgetofood.presentation.screens.favoritesscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject

@Composable
fun FavoritesScreen(
    modifier: Modifier,
    onRecipeClick: (String) -> Unit,
    viewModel: FavoritesViewModel = koinInject(),
) {

    val state by viewModel.state.collectAsState()

}