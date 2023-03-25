package com.rodrigoguerrero.data.storage.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.rodrigoguerrero.data.storage.entities.CategoryEntity
import com.rodrigoguerrero.data.storage.entities.RecurringExpenseEntity
import com.rodrigoguerrero.data.storage.entities.RecurringExpenseWithCategory
import java.util.*
import kotlinx.coroutines.flow.Flow

@Dao
internal interface RecurringExpenseDao {

    @Insert(onConflict = REPLACE)
    suspend fun addRecurringExpense(expense: RecurringExpenseEntity)

    @Insert(onConflict = REPLACE)
    suspend fun addCategory(categoryEntity: CategoryEntity)

    @Transaction
    @Query("SELECT * FROM recurring_expense WHERE id = :id")
    suspend fun getRecurringExpense(id: UUID): RecurringExpenseWithCategory

    @Transaction
    @Query("SELECT * FROM recurring_expense")
    fun getAllRecurringExpenses(): Flow<List<RecurringExpenseWithCategory>>

    @Transaction
    @Update
    suspend fun updateRecurringExpense(expense: RecurringExpenseEntity)

    @Query("DELETE FROM recurring_expense where id = :id")
    suspend fun removeRecurringExpense(id: UUID)
}
