package com.example.fridgetofood.presentation.screens.searchscreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import org.koin.compose.koinInject

@Composable
fun SearchScreen(
    modifier: Modifier,
    onRecipeClick: (String) -> Unit,
    viewModel: SearchViewModel = koinInject(),
) {

    val state by viewModel.state.collectAsState()

}