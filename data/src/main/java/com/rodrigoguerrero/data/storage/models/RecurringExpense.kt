package com.rodrigoguerrero.data.storage.models

data class RecurringExpense(
    val id: String,
    val amount: String,
    val dayOfMonth: Int,
    val category: Category,
    val description: String,
    val interval: String
)
