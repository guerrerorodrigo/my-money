package com.rodrigoguerrero.domain.models

data class Category(
    val id: Int,
    val name: String,
    val parentCategory: String?
)
