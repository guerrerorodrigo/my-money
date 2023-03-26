package com.rodrigoguerrero.mymoney.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun AddExpenseBottomBar(
    modifier: Modifier = Modifier,
    onAddExpense: () -> Unit
) {
    Button(
        onClick = onAddExpense,
        shape = MyMoneyTheme.shapes.medium,
        modifier = modifier.padding(all = MyMoneyTheme.padding.m)
    ) {
        Text(
            text = stringResource(id = R.string.add_expense_button),
            style = MyMoneyTheme.typography.titleMedium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MyMoneyTheme.padding.xs),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )
    }
}
