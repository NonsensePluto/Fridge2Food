package com.example.fridgetofood.presentation.ui.tryitscreen

import androidx.lifecycle.ViewModel
import com.example.fridgetofood.domain.usecases.remote.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopDietsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase
import com.example.fridgetofood.domain.usecases.userpreferences.GetTopCuisinesUseCase
import com.example.fridgetofood.presentation.mappers.RecipeDomainToUiMapper
import com.example.fridgetofood.presentation.mappers.RecipeUiToDomainMapper
import com.example.fridgetofood.presentation.models.RecipeUi
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TryItViewModel(
    private val getRandomRecipesUseCase: GetRandomRecipesUseCase,
    private val getTopDietsUseCase: GetTopDietsUseCase,
    private val getTopCuisinesUseCase: GetTopCuisinesUseCase,
    private val switchFavoritesUseCase: SwitchFavoritesUseCase,
    private val domainToUiMapper: RecipeDomainToUiMapper,
    private val uiToDomainMapper: RecipeUiToDomainMapper,
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
                    limit = 10,
                    diet = topDiets.randomOrNull(),
                    cuisines = topCuisines.randomOrNull(),
                )
                Napier.d("TryItViewModel: received ${randomRecipes.size} recipes")
                val recipesUi = domainToUiMapper.mapList(randomRecipes)
                _state.update { state ->
                    state.copy(
                        recipes = recipesUi,
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

    fun switchRecipeFavorites(recipe: RecipeUi) {
        Napier.d("TryItViewModel: switchRecipeFavorites() — recipeId=${recipe.id}")
        viewModelScope.launch {
            try {
                switchFavoritesUseCase(uiToDomainMapper(recipe))
                Napier.d("TryItViewModel: switchRecipeFavorites() success")
                _state.update { state ->
                    state.copy(
                        recipes = state.recipes.map {
                            if (it.id == recipe.id) it.copy(isFavorite = !it.isFavorite) else it
                        }
                    )
                }
            } catch (e: Exception) {
                Napier.e("TryItViewModel: switchRecipeFavorites() failed", e)
            }
        }
    }
}