package com.rodrigoguerrero.data.storage.models

import java.util.UUID

data class RecurringExpense(
    val id: String,
    val amount: Long,
    val dayOfMonth: Int,
    val category: String,
    val description: String,
    val interval: String
)
