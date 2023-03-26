package com.rodrigoguerrero.mymoney.models

data class AddExpenseUiState(
    val isLoading: Boolean = false,
    val selectedCategory: Category? = null,
    val selectedInterval: Interval = Interval.MONTHLY,
    val description: String? = null,
    val amount: String? = null,
    val billingDay: String? = null
) {
    val isButtonEnabled: Boolean get() {
        return !description.isNullOrEmpty() && !amount.isNullOrEmpty()
    }
}
