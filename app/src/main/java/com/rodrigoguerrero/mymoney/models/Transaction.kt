package com.rodrigoguerrero.mymoney.models

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Transaction(
    val name: String,
    @StringRes
    val category: Int,
    val amount: String,
    val icon: ImageVector,
    val iconBackground: Color
)
