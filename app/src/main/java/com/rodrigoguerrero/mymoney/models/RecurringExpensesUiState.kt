package com.rodrigoguerrero.mymoney.models

data class RecurringExpensesUiState(
    val isLoading: Boolean = true,
    val totalPerMonth: String = "",
    val recurringExpenses: List<Transaction> = emptyList()
) {
    val hasRecurringExpenses = !isLoading && recurringExpenses.isNotEmpty()
}
