package com.rodrigoguerrero.mymoney.models

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Category(
    val id: Int,
    val icon: ImageVector,
    val iconBackground: Color,
    @StringRes
    val name: Int,
    val subcategories: List<Category> = emptyList()
)
