package com.rodrigoguerrero.mymoney.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigoguerrero.domain.currency.Money
import com.rodrigoguerrero.domain.repository.RecurringExpensesRepository
import com.rodrigoguerrero.mymoney.models.RecurringExpensesUiState
import com.rodrigoguerrero.mymoney.models.Transaction
import com.rodrigoguerrero.mymoney.models.allCategories
import com.rodrigoguerrero.mymoney.models.categories.otherCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class RecurringExpensesViewModel @Inject constructor(
    private val repository: RecurringExpensesRepository
) : ViewModel() {

    private val _state = MutableStateFlow(RecurringExpensesUiState())
    val state: StateFlow<RecurringExpensesUiState> = _state

    init {
        viewModelScope.launch {
            repository
                .recurringExpenses
                .map { list ->
                    list.map { expense ->
                        val category = allCategories
                            .find { it.id == expense.category.id }
                            ?: otherCategories.find { it.id == 11 }

                        Transaction(
                            name = expense.description,
                            category = category!!.name,
                            amount = Money(
                                value = expense.amount?.toLong() ?: 0L,
                                currencyCode = "EUR"
                            ).toString(),
                            icon = category.icon,
                            iconBackground = category.iconBackground
                        )
                    }
                }
                .collectLatest { result ->
                    _state.update {
                        it.copy(
                            isLoading = false,
                            recurringExpenses = result,
                        )
                    }
                }
        }

        viewModelScope.launch {
            repository
                .recurringExpenses
                .filterNot { it.isEmpty() }
                .collectLatest { expenses ->
                    val total = expenses
                        .map { it.amount?.toLong() ?: 0L }
                        .sumOf { it }
                    _state.update {
                        it.copy(
                            totalPerMonth = Money(value = total, currencyCode = "EUR").toString()
                        )
                    }
                }
        }
    }
}
