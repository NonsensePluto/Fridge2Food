package com.example.fridgetofood.presentation.ui.favoritesscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fridgetofood.domain.usecases.local.GetFavoritesUseCase
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase
import com.example.fridgetofood.presentation.mappers.RecipeDomainToUiMapper
import com.example.fridgetofood.presentation.mappers.RecipeUiToDomainMapper
import com.example.fridgetofood.presentation.models.RecipeUi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesViewModel(
    private val getFavoritesUseCase: GetFavoritesUseCase,
    private val switchFavoritesUseCase: SwitchFavoritesUseCase,
    private val domainToUiMapper: RecipeDomainToUiMapper,
    private val uiToDomainMapper: RecipeUiToDomainMapper,
) : ViewModel() {

    private val _state = MutableStateFlow(FavoritesState())
    val state = _state.asStateFlow()

    init {
        getFavoriteRecipes()
    }

    fun getFavoriteRecipes() {
        viewModelScope.launch {
            getFavoritesUseCase()
                .collect { recipes ->
                    val recipesUi = recipes.map { recipe ->
                        domainToUiMapper.invoke(recipe).copy(isFavorite = true)
                    }
                    _state.update { state ->
                        state.copy(
                            recipes = recipesUi
                        )
                    }
                }
        }
    }

    fun switchRecipeFavorites(recipe: RecipeUi) {
        viewModelScope.launch {
            switchFavoritesUseCase(uiToDomainMapper(recipe))
        }
    }
}