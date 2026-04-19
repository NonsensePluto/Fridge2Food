package com.example.fridgetofood.presentation.tryitscreen

import androidx.lifecycle.ViewModel
import com.example.fridgetofood.domain.usecases.remote.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopDietsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopCuisinesUseCase
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TryItViewModel(
    private val getRandomRecipesUseCase: GetRandomRecipesUseCase,
    private val getTopDietsUseCase: GetTopDietsUseCase,
    private val getTopCuisinesUseCase: GetTopCuisinesUseCase,
    private val switchFavoritesUseCase: SwitchFavoritesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow(TryItState())
    val state = _state.asStateFlow()

    init {
        getRecipesByUserPreferences()
    }

    fun getRecipesByUserPreferences() {
        _state.update { state ->
            state.copy(
                isLoading = true
            )
        }
        viewModelScope.launch {
            val topDiets = getTopDietsUseCase(3)
            val topCuisines = getTopCuisinesUseCase(3)
            val randomRecipes = getRandomRecipesUseCase(
                limit = 20,
                diet = topDiets.random(),
                cuisines = topCuisines.random(),
            )
            _state.update { state ->
                state.copy(
                    recipes = randomRecipes,
                    isLoading = false,
                )
            }
        }
    }

    fun switchRecipeFavorites(recipe: Recipe) {
        viewModelScope.launch {
            switchFavoritesUseCase(recipe)
        }
    }

//    private fun loadFavoriteStatus(bookId: String): Boolean {
        //TODO сделать модельку реуепта для ui и а маппере моделек сделать как раз этот запрос isFavorite()

}