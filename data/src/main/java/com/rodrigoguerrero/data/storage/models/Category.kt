package com.rodrigoguerrero.data.storage.models

data class Category(
    val id: Int,
    val name: String,
    val parentCategory: String?
)
