package com.rodrigoguerrero.mymoney.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme
import kotlinx.coroutines.launch

private enum class TransactionsTabs(@StringRes val textRes: Int) {
    RECURRING(R.string.recurring),
    SPENDINGS(R.string.spendings),
    INCOME(R.string.income)
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TransactionsScreen(
    modifier: Modifier = Modifier
) {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            tabs = {
                TransactionsTabs.values().forEachIndexed { index, tab ->
                    Tab(
                        selected = index == pagerState.currentPage,
                        onClick = {
                            coroutineScope.launch { pagerState.animateScrollToPage(index) }
                        },
                        text = {
                            Text(text = stringResource(id = tab.textRes))
                        }
                    )
                }
            }
        )

        HorizontalPager(
            count = TransactionsTabs.values().size,
            state = pagerState
        ) { index ->
            Column(
                modifier = modifier
                    .background(color = MyMoneyTheme.color.background)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top
            ) {
                when (index) {
                    TransactionsTabs.INCOME.ordinal -> {}
                    TransactionsTabs.RECURRING.ordinal -> TransactionListScreen(
                        transactions = listOf(),
                        total = "0"
                    )
                    TransactionsTabs.SPENDINGS.ordinal -> {}
                }
            }
        }
    }
}
