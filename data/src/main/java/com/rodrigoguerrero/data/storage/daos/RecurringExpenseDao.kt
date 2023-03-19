package com.rodrigoguerrero.data.storage.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.rodrigoguerrero.data.storage.entities.RecurringExpenseEntity
import java.util.UUID
import kotlinx.coroutines.flow.Flow

@Dao
internal interface RecurringExpenseDao {

    @Insert(onConflict = REPLACE)
    suspend fun addRecurringExpense(expense: RecurringExpenseEntity)

    @Query("SELECT * FROM recurring_expense WHERE id = :id")
    suspend fun getRecurringExpense(id: UUID): RecurringExpenseEntity

    @Query("SELECT * FROM recurring_expense")
    fun getAllRecurringExpenses(): Flow<RecurringExpenseEntity>

    @Update
    suspend fun updateRecurringExpense(expense: RecurringExpenseEntity)

    @Query("DELETE FROM recurring_expense where id = :id")
    suspend fun removeRecurringExpense(id: UUID)
}
