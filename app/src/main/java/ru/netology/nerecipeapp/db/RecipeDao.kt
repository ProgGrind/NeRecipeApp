package ru.netology.nerecipeapp.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RecipeDao {
    @Query("SELECT * FROM posts ORDER BY id DESC")
    fun getAll(): LiveData<List<RecipeEntity>>

    @Insert
    fun insert(recipe: RecipeEntity)

    @Query("UPDATE posts SET description = :description WHERE id = :id")
    fun updateContentById(id: Long, description: String)

//    @Query("""
//        UPDATE posts SET
//        likes = likes + CASE WHEN likedByMe THEN -1 ELSE 1 END,
//        likedByMe = CASE WHEN likedByMe THEN 0 ELSE 1 END
//        WHERE id = :id
//        """)
//    fun likeById(id: Long)

//    @Query("""
//        UPDATE posts SET
//        shares = shares +  1,
//        shared = 1
//        WHERE id = :id
//        """)
//    fun shareById(id: Long)

    @Query("DELETE FROM posts WHERE id = :id")
    fun removeById(id: Long)
}