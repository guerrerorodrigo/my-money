package com.rodrigoguerrero.mymoney.screens

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.components.common.ClickableSection
import com.rodrigoguerrero.mymoney.components.common.ClickableSectionWithIcon
import com.rodrigoguerrero.mymoney.components.common.EditableSectionWithIcon
import com.rodrigoguerrero.mymoney.components.common.EditableTextField
import com.rodrigoguerrero.mymoney.components.common.TopBarWithTitle
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme
import com.rodrigoguerrero.mymoney.viewmodels.AddExpenseViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AddExpenseScreen(
    modifier: Modifier = Modifier,
    viewModel: AddExpenseViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onClose: () -> Unit,
    onBankAccountClicked: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        skipHalfExpanded = true,
        confirmValueChange = { false }
    )

    var description by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var billingDay by remember { mutableStateOf("") }

    BackHandler(bottomSheetState.isVisible) {
        coroutineScope.launch {
            viewModel.onCategoriesDismissed()
            bottomSheetState.hide()
        }
    }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            when {
                state.showCategoriesScreen -> CategoriesBottomSheet(
                    onDismiss = {
                        coroutineScope.launch {
                            viewModel.onCategoriesDismissed()
                            bottomSheetState.hide()
                        }
                    },
                    onCategorySelected = { id ->
                        coroutineScope.launch {
                            viewModel.onCategorySelected(id)
                            viewModel.onCategoriesDismissed()
                            bottomSheetState.hide()
                        }
                    }
                )
            }
        },
        sheetShape = MyMoneyTheme.shapes.medium,
        sheetBackgroundColor = MyMoneyTheme.color.background
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
                    onClick = {
                        viewModel.onAddExpense(description, amount, billingDay)
                    },
                    shape = MyMoneyTheme.shapes.medium,
                    modifier = Modifier.padding(all = MyMoneyTheme.padding.m)
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
                    cursorColor = MyMoneyTheme.color.onSecondaryContainer,
                    text = description,
                    onTextChanged = { description = it }
                )

                ClickableSectionWithIcon(
                    icon = state.selectedCategory?.icon ?: Icons.Outlined.Category,
                    iconBackgroundColor = state.selectedCategory?.iconBackground
                        ?: MyMoneyTheme.color.secondaryContainer,
                    text = stringResource(id = state.selectedCategory?.name ?: R.string.category),
                    label = stringResource(id = R.string.category),
                    onClicked = {
                        coroutineScope.launch {
                            viewModel.showCategoriesBottomSheet()
                            bottomSheetState.show()
                        }
                    }
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
                        modifier = Modifier.weight(1f),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        text = amount,
                        onTextChanged = { amount = it }
                    )
                    ClickableSection(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = R.string.month),
                        label = stringResource(
                            id = R.string.interval
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
                    cursorColor = MyMoneyTheme.color.onPrimaryContainer,
                    text = billingDay,
                    onTextChanged = { billingDay = it }
                )
            }
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
            onBankAccountClicked = { }
        )
    }
}
