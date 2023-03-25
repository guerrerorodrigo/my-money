package com.rodrigoguerrero.data.storage.models

import com.rodrigoguerrero.data.storage.entities.CategoryEntity
import com.rodrigoguerrero.data.storage.entities.RecurringExpenseEntity
import com.rodrigoguerrero.data.storage.entities.RecurringExpenseWithCategory
import java.util.*

internal fun RecurringExpenseWithCategory.toModel() = RecurringExpense(
    id = recurringExpense.id.toString(),
    amount = recurringExpense.amount,
    interval = recurringExpense.interval,
    description = recurringExpense.description,
    category = categoryEntity.toModel(),
    dayOfMonth = recurringExpense.dayOfMonth
)

internal fun CategoryEntity.toModel() = Category(
    id = id,
    name = name,
    parentCategory = parentCategory
)

internal fun RecurringExpense.toEntity() = RecurringExpenseEntity(
    id = UUID.fromString(id),
    amount = amount,
    interval = interval,
    description = description,
    dayOfMonth = dayOfMonth,
    categoryId = category.id
)

internal fun Category.toEntity() = CategoryEntity(
    id = id,
    name = name,
    parentCategory = parentCategory
)
