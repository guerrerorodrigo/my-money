package com.rodrigoguerrero.mymoney.models.categories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Coffee
import androidx.compose.material.icons.outlined.Liquor
import androidx.compose.material.icons.outlined.LocalBar
import androidx.compose.material.icons.outlined.RestaurantMenu
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.models.Category

val foodCategories = listOf(
    Category(
        id = 33,
        icon = Icons.Outlined.ShoppingBag,
        iconBackground = Color(0xFF03A9F4),
        name = R.string.category_food_groceries,
        parentCategoryId = 7
    ),
    Category(
        id = 34,
        icon = Icons.Outlined.Coffee,
        iconBackground = Color(0xFF03A9F4),
        name = R.string.category_food_lunch,
        parentCategoryId = 7
    ),
    Category(
        id = 35,
        icon = Icons.Outlined.RestaurantMenu,
        iconBackground = Color(0xFF03A9F4),
        name = R.string.category_food_restaurants,
        parentCategoryId = 7
    ),
    Category(
        id = 36,
        icon = Icons.Outlined.Liquor,
        iconBackground = Color(0xFF03A9F4),
        name = R.string.category_food_alcohol,
        parentCategoryId = 7
    ),
    Category(
        id = 37,
        icon = Icons.Outlined.LocalBar,
        iconBackground = Color(0xFF03A9F4),
        name = R.string.category_food_bars,
        parentCategoryId = 7
    ),
    Category(
        id = 38,
        icon = Icons.Outlined.Circle,
        iconBackground = Color(0xFF03A9F4),
        name = R.string.category_food_other,
        parentCategoryId = 7
    ),
)
