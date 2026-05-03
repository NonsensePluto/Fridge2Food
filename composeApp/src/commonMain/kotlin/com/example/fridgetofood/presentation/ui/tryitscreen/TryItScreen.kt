package com.example.fridgetofood.presentation.ui.tryitscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import com.example.fridgetofood.domain.models.Ingredient
import com.example.fridgetofood.domain.models.Recipe
import com.example.fridgetofood.presentation.ui.RecipeCard
import fridgetofood.composeapp.generated.resources.RecipeBg
import fridgetofood.composeapp.generated.resources.Res
import org.koin.compose.koinInject

@Composable
fun TryItScreen(
    modifier: Modifier = Modifier,
    onRecipeClick: (Int) -> Unit,
    viewModel: TryItViewModel = koinInject(),
) {
    val state by viewModel.state.collectAsState()

    TryItContent(
        modifier = modifier,
        state = state,
        onRecipeClick = onRecipeClick,
        onToggleFavorite = { recipeId ->
            val recipe = state.recipes.find { it.id == recipeId }
            recipe?.let { viewModel.switchRecipeFavorites(it) }
        },
    )
}

@Composable
fun TryItContent(
    modifier: Modifier = Modifier,
    state: TryItState,
    onRecipeClick: (Int) -> Unit,
    onToggleFavorite: (Int) -> Unit,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Image(
            painter = painterResource(Res.drawable.RecipeBg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White.copy(alpha = 0.40f))
        )

        when {
            state.isLoading -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    CircularProgressIndicator()
                }
            }

            state.errorMessage != null -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = state.errorMessage,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.error,
                    )
                }
            }

            state.recipes.isEmpty() -> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = "У Вас еще нет сохраненных рецептов в избранном",
                        style = MaterialTheme.typography.bodyLarge,
                    )
                }
            }

            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    items(
                        items = state.recipes,
                        key = { it.id },
                    ) { recipe ->
                        RecipeCard(
                            recipe = recipe,
                            onRecipeClick = onRecipeClick,
                            onToggleFavorite = onToggleFavorite,
                            isFavorite = false,
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun TryItContentPreview() {
    TryItContent(
        state = TryItState(
            recipes = listOf(
                Recipe(
                    id = 1,
                    title = "Клубничный смузи",
                    imageUrl = null,
                    ingredients = listOf(
                        Ingredient(id = "1", name = "клубника"),
                        Ingredient(id = "2", name = "молоко"),
                        Ingredient(id = "3", name = "мед"),
                        Ingredient(id = "4", name = "ванильный сахар"),
                        Ingredient(id = "5", name = "мята"),
                    ),
                ),
                Recipe(
                    id = 2,
                    title = "Пицца по-деревенски",
                    imageUrl = null,
                    ingredients = listOf(
                        Ingredient(id = "6", name = "готовое тесто"),
                        Ingredient(id = "7", name = "салями"),
                        Ingredient(id = "8", name = "помидоры"),
                        Ingredient(id = "9", name = "маслины"),
                        Ingredient(id = "10", name = "сыр"),
                        Ingredient(id = "11", name = "базилик"),
                    ),
                ),
            ),
        ),
        onRecipeClick = {},
        onToggleFavorite = {},
    )
}
