package ru.netology.nerecipeapp.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.netology.nerecipeapp.data.Category

@Entity(tableName = "recipes")
class RecipeEntity (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long,
    val author: String,
    val category: Category,
    val name: String,
    val description: String,
    val time: String,
    val recipe: String,
    val like: Boolean = false,
    val picture: String = ""
//    val likedByMe: Boolean = false,
)