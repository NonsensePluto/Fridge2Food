package com.example.fridgetofood.presentation.tryitscreen

import androidx.lifecycle.ViewModel
import com.example.fridgetofood.domain.model.Recipe
import com.example.fridgetofood.domain.usecase.remote.GetRandomRecipesUseCase
import com.example.fridgetofood.domain.usecase.userpreferences.GetTopDietsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.lifecycle.viewModelScope
import com.example.fridgetofood.domain.usecase.userpreferences.GetTopCuisinesUseCase
import kotlinx.coroutines.launch

class TryItViewModel(
    private val getRandomRecipesUseCase: GetRandomRecipesUseCase,
    private val getTopDietsUseCase: GetTopDietsUseCase,
    private val getTopCuisinesUseCase: GetTopCuisinesUseCase
) : ViewModel() {


    private val _recipes = MutableStateFlow<List<Recipe>>(emptyList())
    val recipes = _recipes

    fun getRecipesByUserPreferences() {
        viewModelScope.launch {
            val topDiets = getTopDietsUseCase(3)
            val topCuisines = getTopCuisinesUseCase(3)
            val randomRecipes = getRandomRecipesUseCase(
                limit = 20,
                diet = topDiets.random(),
                cuisines = topCuisines.random(),
            )

            _recipes.value = randomRecipes
        }
    }

}