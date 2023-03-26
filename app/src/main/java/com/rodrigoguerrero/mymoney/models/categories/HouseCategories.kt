package com.rodrigoguerrero.mymoney.models.categories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Bed
import androidx.compose.material.icons.outlined.HomeRepairService
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.models.Category

val houseCategories = listOf(
    Category(
        id = 12,
        icon = Icons.Outlined.Spa,
        iconBackground = Color(0xFF673AB7),
        name = R.string.category_house_garden,
        parentCategoryId = 4
    ),
    Category(
        id = 13,
        icon = Icons.Outlined.Bed,
        iconBackground = Color(0xFF673AB7),
        name = R.string.category_house_furniture,
        parentCategoryId = 4
    ),
    Category(
        id = 14,
        icon = Icons.Outlined.HomeRepairService,
        iconBackground = Color(0xFF673AB7),
        name = R.string.category_house_repairs,
        parentCategoryId = 4
    ),
)
