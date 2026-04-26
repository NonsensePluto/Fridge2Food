package com.example.fridgetofood.presentation.navigation

sealed class Route {

    data class MainScreen(val route: String = "main") : Route()

    data class Details(
        val route: String = "recipe_details",
        val routeWithArgs: String = "$route/{$RECIPE_ID}"
    ) : Route() {

        fun getRouteWithArgs(recipeId: String): String = "$route/$recipeId"

        companion object {
            const val RECIPE_ID = "RecipeId"
        }
    }

    data class FavoritesScreen(val route: String = "favorites") : Route()

}