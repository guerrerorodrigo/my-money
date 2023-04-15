package com.rodrigoguerrero.domain.repository

import com.rodrigoguerrero.domain.models.RequestResult
import com.rodrigoguerrero.data.storage.datasource.RecurringExpenseDataSource
import com.rodrigoguerrero.domain.models.RecurringExpense
import com.rodrigoguerrero.domain.models.toDataModel
import com.rodrigoguerrero.domain.models.toDomainModel
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

internal class RecurringExpensesRepositoryImpl @Inject constructor(
    private val dataSource: RecurringExpenseDataSource
) : RecurringExpensesRepository {

    override val recurringExpenses: Flow<List<RecurringExpense>> = dataSource.recurringExpenses
        .map { list ->
            list.map { it.toDomainModel() }
        }

    override fun getRecurringExpense(id: String): Flow<RequestResult<RecurringExpense>> = flow {
        emit(RequestResult.Loading)
        val result = dataSource.getRecurringExpense(id)

        emit(RequestResult.Success(result.toDomainModel()))
    }
    .catch { emit(RequestResult.Error(it)) }
    .flowOn(Dispatchers.IO)

    override suspend fun addRecurringExpense(recurringExpense: RecurringExpense) {
        val amount = formatAmount(recurringExpense.amount ?: "0")
        dataSource.addRecurringExpense(recurringExpense.toDataModel(amount))
    }

    private fun formatAmount(value: String): Long {
        val amount = value.replace(',', '.')
        return (amount.toFloat() * 100).toLong()
    }
}
