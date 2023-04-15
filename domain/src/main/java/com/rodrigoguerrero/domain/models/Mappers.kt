package com.rodrigoguerrero.domain.models

import com.rodrigoguerrero.data.storage.models.Category as CategoryData
import com.rodrigoguerrero.data.storage.models.RecurringExpense as RecurringExpenseData

fun RecurringExpenseData.toDomainModel() = RecurringExpense(
    id = id,
    amount = amount.toString(),
    category = category.toDomainModel(),
    dayOfMonth = dayOfMonth,
    description = description,
    interval = interval
)

fun CategoryData.toDomainModel() = Category(
    id = id,
    name = name,
    parentCategoryId = parentCategoryId
)

fun Category.toDataModel() = CategoryData(
    id = id,
    name = name,
    parentCategoryId = parentCategoryId
)

fun RecurringExpense.toDataModel(amount: Long) = RecurringExpenseData(
    id = id,
    amount = amount,
    category = category.toDataModel(),
    dayOfMonth = dayOfMonth,
    description = description,
    interval = interval
)
