package com.rodrigoguerrero.mymoney.components

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Movement(
    val name: String,
    val category: String,
    val amount: String,
    val icon: ImageVector,
    val iconBackground: Color
)
