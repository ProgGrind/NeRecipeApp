package ru.netology.nerecipeapp.data

import androidx.lifecycle.map
import ru.netology.nerecipeapp.db.RecipeDao
import ru.netology.nerecipeapp.db.toEntity
import ru.netology.nerecipeapp.db.toModel


class RecipeRepositoryImpl(
    private val dao: RecipeDao
) : RecipeRepository {

    private val recipes
        get() = checkNotNull(data.value) {
            "Data value should not be null"
        }

    override val data =  dao.getAll().map { entities ->
        entities.map { it.toModel() }
    }

    override fun save(recipe: Recipe) {
        if (recipe.id == RecipeRepository.NEW_RECIPE_ID) dao.insert(recipe.toEntity())
        else dao.updateContentById(recipe.id, recipe.recipe)
    }

    override fun search(recipeName: String) {
        dao.search(recipeName)
    }

    override fun getCategory(category: Category) {
        dao.filterByCategory(category)
    }

    override fun update() {
        TODO("Not yet implemented")
    }

//    override fun update(recipeId: Long) {
//        dao.updateContentById(recipeId)
//    }

    override fun like(recipeId: Long) {
        dao.likeById(recipeId)
    }

    override fun delete(recipeId: Long) {
        dao.removeById(recipeId)
    }
}