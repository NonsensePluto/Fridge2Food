package com.example.fridgetofood

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform