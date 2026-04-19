package com.example.fridgetofood.di

import com.example.fridgetofood.presentation.favoritesscreen.FavoritesViewModel
import com.example.fridgetofood.presentation.searchscreen.SearchViewModel
import com.example.fridgetofood.presentation.tryitscreen.TryItViewModel
import org.koin.dsl.module

val presentationModule = module {

    single<SearchViewModel> {
        SearchViewModel(get(), get())
    }

    single<TryItViewModel> {
        TryItViewModel(get(), get(), get(), get())
    }

    single<FavoritesViewModel> {
        FavoritesViewModel(get(), get())
    }
}