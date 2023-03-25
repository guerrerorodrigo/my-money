package com.rodrigoguerrero.domain.models

data class RecurringExpense(
    val id: String,
    val amount: Long,
    val dayOfMonth: Int,
    val category: Category,
    val description: String,
    val interval: String
)
