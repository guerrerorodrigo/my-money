package com.rodrigoguerrero.domain.di

import com.rodrigoguerrero.domain.repository.RecurringExpensesRepository
import com.rodrigoguerrero.domain.repository.RecurringExpensesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    internal abstract fun bindRecurringExpensesRepository(
        recurringExpensesRepository: RecurringExpensesRepositoryImpl
    ): RecurringExpensesRepository
}
