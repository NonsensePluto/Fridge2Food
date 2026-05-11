package com.example.fridgetofood.di

import com.example.fridgetofood.presentation.mappers.RecipeDomainToUiMapper
import com.example.fridgetofood.presentation.mappers.RecipeUiToDomainMapper
import com.example.fridgetofood.presentation.ui.favoritesscreen.FavoritesViewModel
import com.example.fridgetofood.presentation.ui.searchscreen.SearchViewModel
import com.example.fridgetofood.presentation.ui.tryitscreen.TryItViewModel
import org.koin.dsl.module

val presentationModule = module {

    single { RecipeDomainToUiMapper(get()) }
    single { RecipeUiToDomainMapper() }

    single<SearchViewModel> {
        SearchViewModel(get(), get(), get(), get())
    }

    single<TryItViewModel> {
        TryItViewModel(get(), get(), get(), get(), get(), get())
    }

    single<FavoritesViewModel> {
        FavoritesViewModel(get(), get(), get(), get())
    }
}