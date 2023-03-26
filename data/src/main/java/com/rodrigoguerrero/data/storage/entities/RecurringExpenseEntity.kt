package com.rodrigoguerrero.data.storage.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.UUID

@Entity(tableName = "recurring_expense")
internal data class RecurringExpenseEntity(
    @PrimaryKey val id: UUID,
    val amount: String,
    val dayOfMonth: Int,
    val categoryId: Int,
    val description: String,
    val interval: String
)

internal data class RecurringExpenseWithCategory(
    @Embedded val recurringExpense: RecurringExpenseEntity,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "id"
    )
    val categoryEntity: CategoryEntity
)
