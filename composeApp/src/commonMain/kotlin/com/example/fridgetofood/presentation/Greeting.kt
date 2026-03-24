package com.example.fridgetofood.presentation

import com.example.fridgetofood.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}