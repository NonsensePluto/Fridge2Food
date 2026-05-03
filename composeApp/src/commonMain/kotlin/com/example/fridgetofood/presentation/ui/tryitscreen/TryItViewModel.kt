package com.example.fridgetofood.presentation.ui.tryitscreen

import androidx.lifecycle.ViewModel
import com.example.fridgetofood.domain.usecases.remote.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopDietsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopCuisinesUseCase
import io.github.aakira.napier.Napier
import io.ktor.util.logging.Logger
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
        Napier.d("TryItViewModel: init — starting recipe load")
        getRecipesByUserPreferences()
    }

    fun getRecipesByUserPreferences() {
        Napier.d("TryItViewModel: getRecipesByUserPreferences() started")
        _state.update { state ->
            state.copy(
                isLoading = true,
                errorMessage = null,
            )
        }
        viewModelScope.launch {
            try {
                val topDiets = getTopDietsUseCase(3)
                Napier.d("TryItViewModel: topDiets=$topDiets")
                val topCuisines = getTopCuisinesUseCase(3)
                Napier.d("TryItViewModel: topCuisines=$topCuisines")
                val randomRecipes = getRandomRecipesUseCase(
                    limit = 20,
                    diet = topDiets.randomOrNull(),
                    cuisines = topCuisines.randomOrNull(),
                )
                Napier.d("TryItViewModel: received ${randomRecipes.size} recipes")
                _state.update { state ->
                     state.copy(
                        recipes = randomRecipes,
                        isLoading = false,
                    )
                }
            } catch (e: Exception) {
                Napier.e("TryItViewModel: getRecipesByUserPreferences() failed", e)
                _state.update { state ->
                    state.copy(
                        isLoading = false,
                        errorMessage = e.message ?: "Не удалось загрузить рецепты",
                    )
                }
            }
        }
    }

    fun switchRecipeFavorites(recipe: Recipe) {
        Napier.d("TryItViewModel: switchRecipeFavorites() — recipeId=${recipe.id}")
        viewModelScope.launch {
            try {
                switchFavoritesUseCase(recipe)
                Napier.d("TryItViewModel: switchRecipeFavorites() success")
            } catch (e: Exception) {
                Napier.e("TryItViewModel: switchRecipeFavorites() failed", e)
            }
        }
    }

//    private fun loadFavoriteStatus(bookId: String): Boolean {
        //TODO сделать модельку реуепта для ui и а маппере моделек сделать как раз этот запрос isFavorite()

}