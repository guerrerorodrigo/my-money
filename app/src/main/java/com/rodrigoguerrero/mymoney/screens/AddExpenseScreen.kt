package com.rodrigoguerrero.mymoney.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.components.common.ClickableSection
import com.rodrigoguerrero.mymoney.components.common.ClickableSectionWithIcon
import com.rodrigoguerrero.mymoney.components.common.EditableSectionWithIcon
import com.rodrigoguerrero.mymoney.components.common.EditableTextField
import com.rodrigoguerrero.mymoney.components.common.TopBarWithTitle
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExpenseScreen(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onClose: () -> Unit,
    onAddExpense: () -> Unit,
    onBankAccountClicked: () -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopBarWithTitle(
                title = stringResource(id = R.string.add_expense_title),
                onBack = onBack,
                onClose = onClose
            )
        },
        bottomBar = {
            Button(
                onClick = onAddExpense,
                shape = MyMoneyTheme.shapes.medium,
                modifier = Modifier.padding(all = MyMoneyTheme.padding.l)
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
    ) { padding ->
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState())
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.l),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            ClickableSectionWithIcon(
                icon = Icons.Outlined.CreditCard,
                iconBackgroundColor = Color(0xFF9C27B0),
                text = stringResource(id = R.string.wallet),
                label = stringResource(id = R.string.bank_account),
                onClicked = onBankAccountClicked
            )

            EditableSectionWithIcon(
                placeHolder = stringResource(id = R.string.description),
                label = stringResource(id = R.string.description),
                icon = Icons.Outlined.Description,
                iconBackgroundColor = MyMoneyTheme.color.secondaryContainer,
                backgroundColor = MyMoneyTheme.color.secondaryContainer,
                textColor = MyMoneyTheme.color.onSecondaryContainer,
                cursorColor = MyMoneyTheme.color.onSecondaryContainer
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MyMoneyTheme.padding.m),
                horizontalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.m)
            ) {
                EditableTextField(
                    placeholder = stringResource(id = R.string.amount_in_eur),
                    label = stringResource(id = R.string.amount_in_eur),
                    backgroundColor = MyMoneyTheme.color.secondaryContainer,
                    textColor = MyMoneyTheme.color.onSecondaryContainer,
                    cursorColor = MyMoneyTheme.color.onSecondaryContainer,
                    modifier = Modifier.weight(1f)
                )
                ClickableSection(
                    modifier = Modifier.weight(1f),
                    text = stringResource(id = R.string.interval),
                    label = stringResource(
                        id = R.string.month
                    ),
                    onClicked = { }
                )
            }
            EditableTextField(
                modifier = Modifier.padding(horizontal = MyMoneyTheme.padding.m),
                placeholder = stringResource(id = R.string.default_billing_day),
                label = stringResource(id = R.string.billing_day),
                backgroundColor = MyMoneyTheme.color.inversePrimary,
                textColor = MyMoneyTheme.color.onPrimaryContainer,
                cursorColor = MyMoneyTheme.color.onPrimaryContainer
            )
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewAddExpenseScreen() {
    MyMoneyTheme {
        AddExpenseScreen(
            onBack = { },
            onClose = { },
            onAddExpense = { },
            onBankAccountClicked = { }
        )
    }
}
