package com.rodrigoguerrero.mymoney.models

data class AddExpenseUiState(
    val isLoading: Boolean = false,
    val isDescriptionEmpty: Boolean = false,
    val isCategoryEmpty: Boolean = false,
    val isAmountEmpty: Boolean = false,
    val selectedCategory: Category? = null,
    val showCategoriesScreen: Boolean = false
)
