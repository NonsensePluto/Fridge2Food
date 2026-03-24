package com.example.fridgetofood.di

import com.example.fridgetofood.presentation.searchscreen.SearchViewModel
import org.koin.dsl.module

val presentationModule = module {

    single<SearchViewModel> {
        SearchViewModel(get(), get())
    }
}