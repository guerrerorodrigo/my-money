package com.rodrigoguerrero.mymoney.models.categories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.LocalHospital
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.Vaccines
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.models.Category

val wellnessCategories = listOf(
    Category(
        id = 45,
        icon = Icons.Outlined.Star,
        iconBackground = Color(0xFF009688),
        name = R.string.category_wellness_beauty,
        parentCategoryId = 9
    ),
    Category(
        id = 46,
        icon = Icons.Outlined.Visibility,
        iconBackground = Color(0xFF009688),
        name = R.string.category_wellness_eyecare,
        parentCategoryId = 9
    ),
    Category(
        id = 47,
        icon = Icons.Outlined.LocalHospital,
        iconBackground = Color(0xFF009688),
        name = R.string.category_wellness_healthcare,
        parentCategoryId = 9
    ),
    Category(
        id = 48,
        icon = Icons.Outlined.Vaccines,
        iconBackground = Color(0xFF009688),
        name = R.string.category_wellness_medicine,
        parentCategoryId = 9
    ),
    Category(
        id = 49,
        icon = Icons.Outlined.Circle,
        iconBackground = Color(0xFF009688),
        name = R.string.category_wellness_other,
        parentCategoryId = 9
    ),
)
