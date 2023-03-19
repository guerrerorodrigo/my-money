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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.components.TransactionItem
import com.rodrigoguerrero.mymoney.models.Transaction
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun TransactionListScreen(
    modifier: Modifier = Modifier,
    transactions: List<Transaction>,
    total: String,
    onAddTransaction: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = onAddTransaction) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .background(MyMoneyTheme.color.background)
                .fillMaxSize()
                .padding(padding),
            state = rememberLazyListState(),
            contentPadding = PaddingValues(all = MyMoneyTheme.padding.m),
            verticalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.s)
        ) {
            item {
                Column(
                    modifier = Modifier.padding(bottom = MyMoneyTheme.padding.l)
                ) {
                    Text(
                        text = total,
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
            items(transactions) { transaction ->
                TransactionItem(transaction = transaction)
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
                category = "Streaming Services",
                amount = "€14.99",
                icon = Icons.Filled.MusicNote,
                iconBackground = Color.Cyan
            )
            list.add(transaction)
        }
        TransactionListScreen(transactions = list, total = "€1,234.99", onAddTransaction = { })
    }
}
