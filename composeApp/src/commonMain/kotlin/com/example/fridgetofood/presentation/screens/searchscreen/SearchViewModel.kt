package com.example.fridgetofood.presentation.screens.searchscreen

import androidx.lifecycle.ViewModel
import com.example.fridgetofood.domain.usecases.remote.SearchByQueryUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.viewModelScope
import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.domain.usecases.local.SwitchFavoritesUseCase
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchByQueryUseCase: SearchByQueryUseCase,
    private val switchFavoritesUseCase: SwitchFavoritesUseCase,
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
            _state.update { state ->
                state.copy(
                    recipes = searchByQueryUseCase(
                        query = query,
                        number = number,
                        diet = diet,
                        intolerances = intolerances,
                        cuisine = cuisine,
                        maxReadyTime = maxReadyTime
                    ),
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
}