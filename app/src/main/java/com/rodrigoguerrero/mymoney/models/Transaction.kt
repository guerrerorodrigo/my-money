package com.rodrigoguerrero.mymoney.models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class Transaction(
    val name: String,
    val category: String,
    val amount: String,
    val icon: ImageVector,
    val iconBackground: Color
)
