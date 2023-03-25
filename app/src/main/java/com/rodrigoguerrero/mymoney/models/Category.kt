package com.rodrigoguerrero.mymoney.models

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.rodrigoguerrero.mymoney.models.categories.entertainmentCategories
import com.rodrigoguerrero.mymoney.models.categories.expensesCategories
import com.rodrigoguerrero.mymoney.models.categories.foodCategories
import com.rodrigoguerrero.mymoney.models.categories.houseCategories
import com.rodrigoguerrero.mymoney.models.categories.livingCategories
import com.rodrigoguerrero.mymoney.models.categories.otherCategories
import com.rodrigoguerrero.mymoney.models.categories.shoppingCategories
import com.rodrigoguerrero.mymoney.models.categories.transportCategories
import com.rodrigoguerrero.mymoney.models.categories.wellnessCategories

data class Category(
    val id: Int,
    val icon: ImageVector,
    val iconBackground: Color,
    @StringRes
    val name: Int,
    val subcategories: List<Category> = emptyList()
)

val allCategories =
    entertainmentCategories + expensesCategories + foodCategories + houseCategories + livingCategories + otherCategories + shoppingCategories + transportCategories + wellnessCategories