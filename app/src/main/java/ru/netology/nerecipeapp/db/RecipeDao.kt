package ru.netology.nerecipeapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import ru.netology.nerecipeapp.data.Category
import ru.netology.nerecipeapp.data.Recipe

@Dao
interface RecipeDao {
    @Query("SELECT * FROM recipes ORDER BY id DESC")
    fun getAll(): LiveData<List<RecipeEntity>>

    @Insert
    fun insert(recipe: RecipeEntity)

    @Query("UPDATE recipes SET recipe = :recipe WHERE id = :id")
    fun updateContentById(id: Long, recipe: String)

    @Query("""
        UPDATE recipes SET
        like = true
        WHERE id = :id
        """)
    fun likeById(id: Long)

    @Query("SELECT * FROM recipes WHERE name = :name")
    fun search(name: String): LiveData<List<RecipeEntity>>
//    fun search(name: String): Array<Recipe>

    @Query("SELECT * FROM recipes WHERE category = :category")
    fun filterByCategory(category: Category): LiveData<List<RecipeEntity>>
//    fun filterByCategory(category: Category): Array<Recipe>

//    @Query("""
//        UPDATE posts SET
//        shares = shares +  1,
//        shared = 1
//        WHERE id = :id
//        """)
//    fun shareById(id: Long)

    @Query("DELETE FROM recipes WHERE id = :id")
    fun removeById(id: Long)
}