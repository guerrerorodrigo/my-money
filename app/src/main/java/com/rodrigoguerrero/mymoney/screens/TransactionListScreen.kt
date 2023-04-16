package com.rodrigoguerrero.mymoney.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.components.TransactionItem
import com.rodrigoguerrero.mymoney.models.Transaction
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme
import com.rodrigoguerrero.mymoney.viewmodels.RecurringExpensesViewModel

@Composable
fun TransactionListScreen(
    modifier: Modifier = Modifier,
    listHeader: LazyListScope.() -> Unit = { },
    emptyScreen: @Composable () -> Unit = { },
    transactions: List<Transaction>,
    onAddTransaction: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = onAddTransaction) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End,
        backgroundColor = MyMoneyTheme.color.background
    ) { padding ->

        if (transactions.isEmpty()) {
            emptyScreen()
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                state = rememberLazyListState(),
                contentPadding = PaddingValues(
                    top = MyMoneyTheme.padding.m,
                    start = MyMoneyTheme.padding.m,
                    end = MyMoneyTheme.padding.m,
                    bottom = padding.calculateBottomPadding()
                ),
                verticalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.s)
            ) {
                listHeader()
                items(transactions) { transaction ->
                    TransactionItem(transaction = transaction)
                }
            }
        }
    }
}

@Preview(
    name = "Dark Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF201A17
)
@Preview(showBackground = true, backgroundColor = 0xFFFFFBFF)
@Composable
private fun PreviewTransactionListScreen() {
    MyMoneyTheme {
        val list = mutableListOf<Transaction>()
        for (i in 0..50) {
            val transaction = Transaction(
                name = "Spotify $i",
                category = R.string.category_entertainment,
                amount = "€14.99",
                icon = Icons.Filled.MusicNote,
                iconBackground = Color.Cyan
            )
            list.add(transaction)
        }
        TransactionListScreen(onAddTransaction = { }, listHeader = { }, transactions = list)
    }
}
