package com.rodrigoguerrero.data.storage.models

import com.rodrigoguerrero.data.storage.entities.RecurringExpenseEntity
import java.util.*

internal fun RecurringExpenseEntity.toModel() = RecurringExpense(
    id = id.toString(),
    amount = amount,
    interval = interval,
    description = description,
    category = category,
    dayOfMonth = dayOfMonth
)

internal fun RecurringExpense.toEntity() = RecurringExpenseEntity(
    id = UUID.fromString(id),
    amount = amount,
    interval = interval,
    description = description,
    category = category,
    dayOfMonth = dayOfMonth
)
