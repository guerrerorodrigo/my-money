package com.rodrigoguerrero.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "recurring_expense")
internal data class RecurringExpenseEntity(
    @PrimaryKey val id: UUID,
    val amount: Long,
    val dayOfMonth: Int,
    val category: String,
    val description: String,
    val interval: String
)
