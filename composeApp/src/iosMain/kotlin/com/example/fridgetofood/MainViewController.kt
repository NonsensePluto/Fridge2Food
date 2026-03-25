package com.example.fridgetofood

import androidx.compose.ui.window.ComposeUIViewController
import com.example.fridgetofood.di.dataModule
import com.example.fridgetofood.di.domainModule
import com.example.fridgetofood.di.iosPlatformModule
import com.example.fridgetofood.di.presentationModule
import org.koin.core.context.startKoin

fun MainViewController() = ComposeUIViewController {

    startKoin {
        modules(dataModule, domainModule, presentationModule, iosPlatformModule)
    }

    App()
}