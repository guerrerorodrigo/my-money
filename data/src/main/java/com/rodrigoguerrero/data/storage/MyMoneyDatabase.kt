package com.rodrigoguerrero.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rodrigoguerrero.data.storage.daos.RecurringExpenseDao
import com.rodrigoguerrero.data.storage.entities.CategoryEntity
import com.rodrigoguerrero.data.storage.entities.RecurringExpenseEntity

@Database(
    entities = [
        RecurringExpenseEntity::class,
        CategoryEntity::class
    ],
    version = 1
)

abstract class MyMoneyDatabase : RoomDatabase() {
    internal abstract fun recurringExpenseDao(): RecurringExpenseDao
}
