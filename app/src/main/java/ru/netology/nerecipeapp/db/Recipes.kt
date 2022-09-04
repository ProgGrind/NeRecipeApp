package ru.netology.nerecipeapp.db

import android.database.Cursor
import ru.netology.nerecipeapp.data.Category
import ru.netology.nerecipeapp.data.Recipe

internal fun RecipeEntity.toModel() = Recipe(
    id = id,
    author = author,
    category = category,
    name = name,
    description = description,
    time = time,
    recipe = recipe,
    like = like,
    picture = picture
)

internal fun Recipe.toEntity() = RecipeEntity(
    id = id,
    author = author,
    category = category,
    name = name,
    description = description,
    time = time,
    recipe = recipe,
    like = like,
    picture = picture
)