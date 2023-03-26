package com.rodrigoguerrero.mymoney.viewmodels

import androidx.lifecycle.ViewModel
import com.rodrigoguerrero.mymoney.models.AddExpenseUiState
import com.rodrigoguerrero.mymoney.models.Category
import com.rodrigoguerrero.mymoney.models.Interval
import com.rodrigoguerrero.mymoney.models.allCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class AddExpenseViewModel @Inject constructor() : ViewModel() {

    private val selectedCategory = MutableStateFlow<Category?>(null)
    private val _state = MutableStateFlow(AddExpenseUiState())
    val state: StateFlow<AddExpenseUiState> = _state

    fun onAddExpense() {
    }

    fun onCategorySelected(categoryId: Int) {
        selectedCategory.update { allCategories.find { it.id == categoryId } }
        _state.update { it.copy(selectedCategory = selectedCategory.value) }
    }

    fun onIntervalSelected(interval: Interval) {
        _state.update { it.copy(selectedInterval = interval) }
    }

    fun onDescriptionChanged(description: String) {
        _state.update { it.copy(description = description)}
    }

    fun onAmountChanged(amount: String) {
        _state.update { it.copy(amount = amount) }
    }

    fun onBillingDayChanged(billingDay: String) {
        _state.update { it.copy(billingDay = billingDay) }
    }
}
