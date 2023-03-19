package com.rodrigoguerrero.data.di

import android.content.Context
import androidx.room.Room
import com.rodrigoguerrero.data.storage.MyMoneyDatabase
import com.rodrigoguerrero.data.storage.daos.RecurringExpenseDao
import com.rodrigoguerrero.data.storage.datasource.RecurringExpenseDataSource
import com.rodrigoguerrero.data.storage.datasource.RecurringExpenseDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): MyMoneyDatabase {
        return Room.databaseBuilder(context, MyMoneyDatabase::class.java, "my_money_db").build()
    }

    @Singleton
    @Provides
    internal fun provideRecurringExpenseDao(myMoneyDatabase: MyMoneyDatabase): RecurringExpenseDao {
        return myMoneyDatabase.recurringExpenseDao()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class StorageBindingModule {

    @Singleton
    @Binds
    internal abstract fun bindRecurringExpenseDataSource(
        recurringExpenseDataSource: RecurringExpenseDataSourceImpl
    ): RecurringExpenseDataSource
}
