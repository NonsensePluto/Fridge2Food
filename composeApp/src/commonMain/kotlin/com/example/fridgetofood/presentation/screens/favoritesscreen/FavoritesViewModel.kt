package com.example.fridgetofood.presentation.screens.favoritesscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.usecases.local.GetFavoritesUseCase
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase
import com.example.fridgetofood.presentation.screens.tryitscreen.TryItState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val switchFavoritesUseCase: SwitchFavoritesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(TryItState())
    val state = _state.asStateFlow()

    init {
        getFavoriteRecipes()
    }

    fun getFavoriteRecipes() {
        viewModelScope.launch {
            getFavoritesUseCase()
                .collect { recipes ->
                    _state.update { state ->
                        state.copy(
                            recipes = recipes
                        )
                    }
                }
        }
    }

    fun switchRecipeFavorites(recipe: Recipe) {
        viewModelScope.launch {
            switchFavoritesUseCase(recipe)
        }
    }
}