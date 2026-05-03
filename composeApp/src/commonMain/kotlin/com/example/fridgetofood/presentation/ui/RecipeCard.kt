package com.example.fridgetofood.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.fridgetofood.domain.models.Ingredient
import com.example.fridgetofood.domain.models.Recipe


@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: Recipe,
    onRecipeClick: (recipeId: Int) -> Unit,
    onToggleFavorite: (recipeId: Int) -> Unit,
    isFavorite: Boolean,
) {

    Card(
        modifier = modifier.fillMaxWidth(),
        onClick = { onRecipeClick(recipe.id) },
        colors = CardColors(Color.White, Color.Black, Color.Gray, Color.Gray)
    ) {

        Column {
            Box {
                AsyncImage(
                    model = recipe.imageUrl,
                    contentDescription = "Book image",
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop,
                    clipToBounds = true
                )
                IconButton(
                    modifier = Modifier.align(Alignment.TopEnd),
                    onClick = { onToggleFavorite(recipe.id) },
                    colors = IconButtonColors(Color.White, Color.White, Color.Gray, Color.Gray)
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorites Button",
                        tint = if (isFavorite) Color.Red else Color.Black,
                    )
                }
            }
            Column {
                Text(
                    text = recipe.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = recipe.ingredients?.joinToString { it.name } ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.LightGray
                )

            }
        }
    }
}

@Preview
@Composable
fun RecipeCardPreview() {
    RecipeCard(
        recipe = Recipe(
            id = 1,
            title = "Pasta Carbonara",
            imageUrl = null,
            ingredients = listOf(
                Ingredient(id = "1", name = "Pasta"),
                Ingredient(id = "2", name = "Eggs"),
                Ingredient(id = "3", name = "Bacon")
            )
        ),
        onRecipeClick = {},
        onToggleFavorite = {},
        isFavorite = true
    )
}