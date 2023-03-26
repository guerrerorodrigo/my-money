package com.rodrigoguerrero.mymoney.viewmodels

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigoguerrero.domain.models.RecurringExpense
import com.rodrigoguerrero.domain.repository.RecurringExpensesRepository
import com.rodrigoguerrero.mymoney.models.AddExpenseUiState
import com.rodrigoguerrero.mymoney.models.Category
import com.rodrigoguerrero.mymoney.models.Interval
import com.rodrigoguerrero.mymoney.models.allCategories
import com.rodrigoguerrero.mymoney.models.toDomainModel
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class AddExpenseViewModel @Inject constructor(
    private val repository: RecurringExpensesRepository
) : ViewModel() {

    private val selectedCategory = MutableStateFlow<Category?>(null)
    private val _state = MutableStateFlow(AddExpenseUiState())
    val state: StateFlow<AddExpenseUiState> = _state

    fun onAddExpense(resources: Resources) {
        viewModelScope.launch {
            with(_state.value) {
                repository.addRecurringExpense(
                    RecurringExpense(
                        id = UUID.randomUUID().toString(),
                        amount = amount.orEmpty(),
                        category = selectedCategory?.toDomainModel(resources)
                            ?: allCategories.find { it.id == 11 }!!.toDomainModel(resources),
                        dayOfMonth = billingDay?.toInt() ?: 1,
                        description = description.orEmpty(),
                        interval = selectedInterval.name
                    )
                )
                _state.update { it.copy(exit = true) }
            }
        }
    }

    fun onCategorySelected(categoryId: Int) {
        selectedCategory.update { allCategories.find { it.id == categoryId } }
        _state.update { it.copy(selectedCategory = selectedCategory.value) }
    }

    fun onIntervalSelected(interval: Interval) {
        _state.update { it.copy(selectedInterval = interval) }
    }

    fun onDescriptionChanged(description: String) {
        _state.update { it.copy(description = description) }
    }

    fun onAmountChanged(amount: String) {
        _state.update { it.copy(amount = amount) }
    }

    fun onBillingDayChanged(billingDay: String) {
        _state.update { it.copy(billingDay = billingDay) }
    }
}
