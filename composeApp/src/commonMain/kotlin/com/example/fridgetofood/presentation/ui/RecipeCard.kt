package com.example.fridgetofood.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.fridgetofood.presentation.models.RecipeUi


@Composable
fun RecipeCard(
    modifier: Modifier = Modifier,
    recipe: RecipeUi,
    onRecipeClick: (recipeId: Int) -> Unit,
    onToggleFavorite: (recipeId: Int) -> Unit,
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
                    contentDescription = "Recipe image",
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
                        imageVector = if (recipe.isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = "Favorites Button",
                        tint = if (recipe.isFavorite) Color.Red else Color.Black,
                    )
                }
            }
            Column {
                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = recipe.title,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    modifier = Modifier.padding(horizontal = 8.dp),
                    text = recipe.summary?.replace(Regex("<[^>]*>"), "") ?: "",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.LightGray,
                    maxLines = 3,
                )

            }
        }
    }
}

@Preview
@Composable
fun RecipeCardPreview() {
    RecipeCard(
        recipe = RecipeUi(
            id = 1,
            title = "Pasta Carbonara",
            imageUrl = null,
            summary = "Pasta Carbonara is an Italian classic made with eggs, hard cheese, cured pork, and black pepper. It is quick, delicious, and easy to make.",
            isFavorite = true,
        ),
        onRecipeClick = {},
        onToggleFavorite = {},
    )
}