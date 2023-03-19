package com.rodrigoguerrero.data.storage.datasource

import com.rodrigoguerrero.data.storage.daos.RecurringExpenseDao
import com.rodrigoguerrero.data.storage.models.RecurringExpense
import com.rodrigoguerrero.data.storage.models.toEntity
import com.rodrigoguerrero.data.storage.models.toModel
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class RecurringExpenseDataSourceImpl @Inject constructor(
    private val recurringExpenseDao: RecurringExpenseDao
) : RecurringExpenseDataSource {

    override val recurringExpenses: Flow<RecurringExpense> =
        recurringExpenseDao
            .getAllRecurringExpenses()
            .map { it.toModel() }

    override suspend fun getRecurringExpense(id: String): RecurringExpense {
        return recurringExpenseDao.getRecurringExpense(UUID.fromString(id)).toModel()
    }

    override suspend fun addRecurringExpense(expense: RecurringExpense) {
        recurringExpenseDao.addRecurringExpense(expense.toEntity())
    }

    override suspend fun updateExpense(expense: RecurringExpense) {
        recurringExpenseDao.updateRecurringExpense(expense.toEntity())
    }

    override suspend fun removeExpense(id: String) {
        recurringExpenseDao.removeRecurringExpense(UUID.fromString(id))
    }
}
