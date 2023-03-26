package com.rodrigoguerrero.mymoney.models.categories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.MusicNote
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.material.icons.outlined.SportsSoccer
import androidx.compose.material.icons.outlined.WbSunny
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.models.Category

val entertainmentCategories = listOf(
    Category(
        id = 27,
        icon = Icons.Outlined.WbSunny,
        iconBackground = Color(0xFF2196F3),
        name = R.string.category_entertainment_holidays,
        parentCategoryId = 6
    ),
    Category(
        id = 28,
        icon = Icons.Outlined.PlayArrow,
        iconBackground = Color(0xFF2196F3),
        name = R.string.category_entertainment_hobbies,
        parentCategoryId = 6
    ),
    Category(
        id = 29,
        icon = Icons.Outlined.SportsSoccer,
        iconBackground = Color(0xFF2196F3),
        name = R.string.category_entertainment_sports,
        parentCategoryId = 6
    ),
    Category(
        id = 30,
        icon = Icons.Outlined.LocationOn,
        iconBackground = Color(0xFF2196F3),
        name = R.string.category_entertainment_events,
        parentCategoryId = 6
    ),
    Category(
        id = 31,
        icon = Icons.Outlined.Circle,
        iconBackground = Color(0xFF2196F3),
        name = R.string.category_entertainment_other,
        parentCategoryId = 6
    ),
    Category(
        id = 32,
        icon = Icons.Outlined.MusicNote,
        iconBackground = Color(0xFF2196F3),
        name = R.string.category_entertainment_streaming,
        parentCategoryId = 6
    ),
)
