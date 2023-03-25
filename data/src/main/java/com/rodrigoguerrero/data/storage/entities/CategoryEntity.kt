package com.rodrigoguerrero.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
internal data class CategoryEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val parentCategory: String?
)
