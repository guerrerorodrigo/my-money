package com.rodrigoguerrero.domain.repository

import com.rodrigoguerrero.domain.models.RequestResult
import com.rodrigoguerrero.domain.models.RecurringExpense
import kotlinx.coroutines.flow.Flow

interface RecurringExpensesRepository {
    val recurringExpenses: Flow<List<RecurringExpense>>

    fun getRecurringExpense(id: String): Flow<RequestResult<RecurringExpense>>

    suspend fun addRecurringExpense(recurringExpense: RecurringExpense)
}
