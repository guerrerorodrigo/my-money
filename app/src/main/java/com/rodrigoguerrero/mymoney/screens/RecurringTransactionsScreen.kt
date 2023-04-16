package com.rodrigoguerrero.mymoney.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.components.EmptyTransactionList
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme
import com.rodrigoguerrero.mymoney.viewmodels.RecurringExpensesViewModel

@Composable
fun RecurringTransactionsScreen(
    modifier: Modifier = Modifier,
    viewModel: RecurringExpensesViewModel = hiltViewModel(),
    onAddTransaction: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    TransactionListScreen(
        modifier = modifier,
        transactions = state.recurringExpenses,
        onAddTransaction = onAddTransaction,
        listHeader = {
            item { MonthTotal(totalPerMonth = state.totalPerMonth) }
        },
        emptyScreen = {
            EmptyTransactionList(description = stringResource(id = R.string.empty_recurring_expense))
        }
    )
}

@Composable
private fun MonthTotal(totalPerMonth: String) {
    Column(
        modifier = Modifier.padding(bottom = MyMoneyTheme.padding.l)
    ) {
        Text(
            text = totalPerMonth,
            style = MyMoneyTheme.typography.headlineMedium,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = MyMoneyTheme.color.onSurface,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = stringResource(id = R.string.spending_per_month),
            style = MyMoneyTheme.typography.labelLarge,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            color = MyMoneyTheme.color.onSurface
        )
    }
}
