package com.example.fridgetofood.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fridgetofood.presentation.screens.detailsscreen.DetailsScreen
import com.example.fridgetofood.presentation.screens.favoritesscreen.FavoritesScreen
import com.example.fridgetofood.presentation.screens.searchscreen.SearchScreen
import com.example.fridgetofood.presentation.screens.tryitscreen.TryItScreen


@Composable
fun NavigationGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = Route.MainScreen().route,
        modifier = modifier.fillMaxSize()
    ) {

        composable(
            route = Route.MainScreen().route
        ) {
            TryItScreen(
                modifier = modifier,
                onRecipeClick = { recipeId ->
                    navController.navigate(
                        Route.Details().getRouteWithArgs(recipeId)
                    ) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = false
                        }
                    }
                },
//                onNavigateToFavorites = {
//                    navController.navigate(
//                        Route.FavoritesScreen().route
//                    )
//                }
            )
        }

        composable(
            route = Route.Details().routeWithArgs,
            arguments = listOf(
                navArgument(name = Route.Details.RECIPE_ID) {
                    type = NavType.StringType
                }
            )
        ) {
            DetailsScreen(
                modifier = modifier,
//                onNavigateUp = { navController.navigateUp() },
            )
        }

        composable(
            route = Route.FavoritesScreen().route
        ) {
            FavoritesScreen(
                modifier = modifier,
                onRecipeClick = { recipeId ->
                    navController.navigate(
                        Route.Details().getRouteWithArgs(recipeId)
                    ) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = false
                        }
                    }
                },
            )
        }

        composable(
            route = Route.FavoritesScreen().route
        ) {
            SearchScreen(
                modifier = modifier,
                onRecipeClick = { recipeId ->
                    navController.navigate(
                        Route.Details().getRouteWithArgs(recipeId)
                    ) {
                        launchSingleTop = true
                        popUpTo(navController.graph.findStartDestination().id) {
                            inclusive = false
                        }
                    }
                },
            )
        }
    }
}