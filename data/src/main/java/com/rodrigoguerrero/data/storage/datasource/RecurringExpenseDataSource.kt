package com.rodrigoguerrero.data.storage.datasource

import com.rodrigoguerrero.data.storage.models.RecurringExpense
import kotlinx.coroutines.flow.Flow

interface RecurringExpenseDataSource {
    val recurringExpenses: Flow<RecurringExpense>

    suspend fun getRecurringExpense(id: String): RecurringExpense

    suspend fun addRecurringExpense(expense: RecurringExpense)

    suspend fun updateExpense(expense: RecurringExpense)

    suspend fun removeExpense(id: String)
}
