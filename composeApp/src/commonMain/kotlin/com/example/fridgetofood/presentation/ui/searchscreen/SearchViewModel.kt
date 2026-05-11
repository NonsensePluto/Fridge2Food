package com.example.fridgetofood.presentation.ui.searchscreen

import androidx.lifecycle.ViewModel
import com.example.fridgetofood.domain.usecases.remote.SearchByQueryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase
import com.example.fridgetofood.presentation.mappers.RecipeDomainToUiMapper
import com.example.fridgetofood.presentation.mappers.RecipeUiToDomainMapper
import com.example.fridgetofood.presentation.models.RecipeUi
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchByQueryUseCase: SearchByQueryUseCase,
    private val switchFavoritesUseCase: SwitchFavoritesUseCase,
    private val domainToUiMapper: RecipeDomainToUiMapper,
    private val uiToDomainMapper: RecipeUiToDomainMapper,
) : ViewModel() {

    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    fun searchByQuery(
        query: String,
        number: Int = 10,
        diet: String? = null,
        intolerances: String? = null,
        cuisine: String? = null,
        maxReadyTime: Int? = null
    ) {
        _state.update { state ->
            state.copy(
                isLoading = true
            )
        }
        viewModelScope.launch {
            val recipes = searchByQueryUseCase(
                query = query,
                number = number,
                diet = diet,
                intolerances = intolerances,
                cuisine = cuisine,
                maxReadyTime = maxReadyTime
            )
            val recipesUi = domainToUiMapper.mapList(recipes)
            _state.update { state ->
                state.copy(
                    recipes = recipesUi,
                    isLoading = false,
                )
            }
        }
    }

    fun switchRecipeFavorites(recipe: RecipeUi) {
        viewModelScope.launch {
            switchFavoritesUseCase(uiToDomainMapper(recipe))
        }
    }
}