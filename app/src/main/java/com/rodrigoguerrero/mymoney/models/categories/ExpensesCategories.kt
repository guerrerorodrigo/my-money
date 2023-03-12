package com.rodrigoguerrero.mymoney.models.categories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Celebration
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PowerSettingsNew
import androidx.compose.material.icons.outlined.Restaurant
import androidx.compose.material.icons.outlined.Savings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.material.icons.outlined.Train
import androidx.compose.material.icons.outlined.TrendingUp
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.models.Category

val expensesCategories = listOf(
    Category(
        id = 1,
        name = R.string.category_savings,
        icon = Icons.Outlined.Savings,
        iconBackground = Color(0xFFF44336)
    ),
    Category(
        id = 2,
        name = R.string.category_other_transfers,
        icon = Icons.Outlined.Circle,
        iconBackground = Color(0xFFE91E63)
    ),
    Category(
        id = 3,
        name = R.string.category_investments,
        icon = Icons.Outlined.TrendingUp,
        iconBackground = Color(0xFF9C27B0)
    ),
    Category(
        id = 4,
        name = R.string.category_house,
        icon = Icons.Outlined.Home,
        iconBackground = Color(0xFF673AB7),
        subcategories = houseCategories
    ),
    Category(
        id = 5,
        name = R.string.category_living,
        icon = Icons.Outlined.PowerSettingsNew,
        iconBackground = Color(0xFF3F51B5),
        subcategories = livingCategories
    ),
    Category(
        id = 6,
        name = R.string.category_entertainment,
        icon = Icons.Outlined.Celebration,
        iconBackground = Color(0xFF2196F3),
        subcategories = entertainmentCategories
    ),
    Category(
        id = 7,
        name = R.string.category_food,
        icon = Icons.Outlined.Restaurant,
        iconBackground = Color(0xFF03A9F4),
        subcategories = foodCategories
    ),
    Category(
        id = 8,
        name = R.string.category_shopping,
        icon = Icons.Outlined.ShoppingCart,
        iconBackground = Color(0xFF00BCD4),
        subcategories = shoppingCategories
    ),
    Category(
        id = 9,
        name = R.string.category_wellness,
        icon = Icons.Outlined.Spa,
        iconBackground = Color(0xFF009688),
        subcategories = wellnessCategories
    ),
    Category(
        id = 10,
        name = R.string.category_transport,
        icon = Icons.Outlined.Train,
        iconBackground = Color(0xFF4CAF50),
        subcategories = transportCategories
    ),
    Category(
        id = 11,
        name = R.string.category_other,
        icon = Icons.Outlined.Circle,
        iconBackground = Color(0xFF00BCD4),
        subcategories = otherCategories
    )
)
