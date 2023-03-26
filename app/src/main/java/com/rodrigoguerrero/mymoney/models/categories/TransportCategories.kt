package com.rodrigoguerrero.mymoney.models.categories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.DirectionsBus
import androidx.compose.material.icons.outlined.DirectionsCar
import androidx.compose.material.icons.outlined.Flight
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.models.Category

val transportCategories = listOf(
    Category(
        id = 50,
        icon = Icons.Outlined.DirectionsCar,
        iconBackground = Color(0xFF4CAF50),
        name = R.string.category_transport_car,
        parentCategoryId = 10
    ),
    Category(
        id = 51,
        icon = Icons.Outlined.DirectionsBus,
        iconBackground = Color(0xFF4CAF50),
        name = R.string.category_transport_public,
        parentCategoryId = 10
    ),
    Category(
        id = 52,
        icon = Icons.Outlined.Flight,
        iconBackground = Color(0xFF4CAF50),
        name = R.string.category_transport_flights,
        parentCategoryId = 10
    ),
    Category(
        id = 53,
        icon = Icons.Outlined.Circle,
        iconBackground = Color(0xFF4CAF50),
        name = R.string.category_transport_other,
        parentCategoryId = 10
    ),
)
