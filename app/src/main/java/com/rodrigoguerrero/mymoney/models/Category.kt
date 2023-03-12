package com.rodrigoguerrero.mymoney.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    val id: Int,
    val icon: ImageVector,
    val iconBackground: Color,
    val name: String,
    val subcategories: List<Category>
)
