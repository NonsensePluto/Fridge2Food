package com.example.fridgetofood.data.local.entety

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class SavedRecipeWithRelations(
    @Embedded
    val recipe: SavedRecipeEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = RecipeIngredientCrossRef::class,
            parentColumn = "recipeId",
            entityColumn = "ingredientId"
        )
    )
    val ingredients: List<IngredientEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "name",
        associateBy = Junction(
            value = RecipeDietCrossRef::class,
            parentColumn = "recipeId",
            entityColumn = "dietName"
        )
    )
    val diets: List<DietEntity>,
    @Relation(
        parentColumn = "id",
        entityColumn = "name",
        associateBy = Junction(
            value = RecipeCuisineCrossRef::class,
            parentColumn = "recipeId",
            entityColumn = "cuisineName"
        )
    )
    val cuisines: List<CuisineEntity>,
)