package com.rodrigoguerrero.mymoney.models.categories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Book
import androidx.compose.material.icons.outlined.Checkroom
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.PhotoCamera
import androidx.compose.material.icons.outlined.Redeem
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.models.Category

val shoppingCategories = listOf(
    Category(
        id = 39,
        icon = Icons.Outlined.Redeem,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_shopping_gifts,
        parentCategoryId = 8
    ),
    Category(
        id = 40,
        icon = Icons.Outlined.Book,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_shopping_books,
        parentCategoryId = 8
    ),
    Category(
        id = 41,
        icon = Icons.Outlined.Checkroom,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_shopping_clothes,
        parentCategoryId = 8
    ),
    Category(
        id = 42,
        icon = Icons.Outlined.Edit,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_shopping_hobbies,
        parentCategoryId = 8
    ),
    Category(
        id = 43,
        icon = Icons.Outlined.PhotoCamera,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_shopping_electronics,
        parentCategoryId = 8
    ),
    Category(
        id = 44,
        icon = Icons.Outlined.Circle,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_shopping_other,
        parentCategoryId = 8
    ),
)
