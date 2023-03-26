package com.rodrigoguerrero.mymoney.models.categories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Album
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.ChildCare
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Help
import androidx.compose.material.icons.outlined.Language
import androidx.compose.material.icons.outlined.LocalAtm
import androidx.compose.material.icons.outlined.Pets
import androidx.compose.material.icons.outlined.Reply
import androidx.compose.material.icons.outlined.School
import androidx.compose.material.icons.outlined.ThumbUp
import androidx.compose.ui.graphics.Color
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.models.Category

val otherCategories = listOf(
    Category(
        id = 54,
        icon = Icons.Outlined.LocalAtm,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_withdrawals,
        parentCategoryId = 11
    ),
    Category(
        id = 55,
        icon = Icons.Outlined.Description,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_business,
        parentCategoryId = 11
    ),
    Category(
        id = 56,
        icon = Icons.Outlined.ChildCare,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_kids,
        parentCategoryId = 11
    ),
    Category(
        id = 57,
        icon = Icons.Outlined.Pets,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_pets,
        parentCategoryId = 11
    ),
    Category(
        id = 58,
        icon = Icons.Outlined.ThumbUp,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_donations,
        parentCategoryId = 11
    ),
    Category(
        id = 59,
        icon = Icons.Outlined.School,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_education,
        parentCategoryId = 11
    ),
    Category(
        id = 60,
        icon = Icons.Outlined.Help,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_uncategorized,
        parentCategoryId = 11
    ),
    Category(
        id = 61,
        icon = Icons.Outlined.Circle,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_other,
        parentCategoryId = 11
    ),
    Category(
        id = 62,
        icon = Icons.Outlined.CalendarToday,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_lottery,
        parentCategoryId = 11
    ),
    Category(
        id = 63,
        icon = Icons.Outlined.Language,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_political,
        parentCategoryId = 11
    ),
    Category(
        id = 64,
        icon = Icons.Outlined.Album,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_software,
        parentCategoryId = 11
    ),
    Category(
        id = 65,
        icon = Icons.Outlined.Reply,
        iconBackground = Color(0xFF00BCD4),
        name = R.string.category_other_payment,
        parentCategoryId = 11
    ),
)
