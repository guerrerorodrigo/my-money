package com.rodrigoguerrero.mymoney.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rodrigoguerrero.domain.repository.RecurringExpensesRepository
import com.rodrigoguerrero.mymoney.models.RecurringExpensesUiState
import com.rodrigoguerrero.mymoney.models.Transaction
import com.rodrigoguerrero.mymoney.models.allCategories
import com.rodrigoguerrero.mymoney.models.categories.otherCategories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.update
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
                            category = category!!.name.toString(),
                            amount = expense.amount.toString(), // TODO: fix this
                            icon = category.icon,
                            iconBackground = category.iconBackground
                        )
                    }
                }
                .collectLatest { result ->
                    _state.update { it.copy(isLoading = false, recurringExpenses = result) }
                }
        }
    }
}
