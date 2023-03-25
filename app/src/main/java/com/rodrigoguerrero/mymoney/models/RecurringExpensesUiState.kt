package com.rodrigoguerrero.mymoney.models

data class RecurringExpensesUiState(
    val isLoading: Boolean = true,
    val recurringExpenses: List<Transaction> = emptyList()
) {
    val hasRecurringExpenses = !isLoading && recurringExpenses.isNotEmpty()
}
