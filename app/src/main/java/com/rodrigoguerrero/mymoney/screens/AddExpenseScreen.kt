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
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.components.AddExpenseBottomBar
import com.rodrigoguerrero.mymoney.components.AddExpensesBottomSheets
import com.rodrigoguerrero.mymoney.components.common.ClickableSection
import com.rodrigoguerrero.mymoney.components.common.ClickableSectionWithIcon
import com.rodrigoguerrero.mymoney.components.common.EditableSectionWithIcon
import com.rodrigoguerrero.mymoney.components.common.EditableTextField
import com.rodrigoguerrero.mymoney.components.common.TopBarWithTitle
import com.rodrigoguerrero.mymoney.models.BottomSheetType
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme
import com.rodrigoguerrero.mymoney.viewmodels.AddExpenseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class, ExperimentalComposeUiApi::class)
@Composable
fun AddExpenseScreen(
    modifier: Modifier = Modifier,
    viewModel: AddExpenseViewModel = hiltViewModel(),
    onBack: () -> Unit,
    onClose: () -> Unit,
) {
    val state by viewModel.state.collectAsState()
    val keyboardController = LocalSoftwareKeyboardController.current
    val context = LocalContext.current
    var bottomSheetType: BottomSheetType by remember { mutableStateOf(BottomSheetType.Categories) }
    val coroutineScope = rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden
    )

    BackHandler(bottomSheetState.isVisible) {
        hideBottomSheet(coroutineScope, bottomSheetState)
    }

    LaunchedEffect(key1 = state.exit) {
        if (state.exit) {
            onBack()
        }
    }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetContent = {
            AddExpensesBottomSheets(
                bottomSheetType = bottomSheetType,
                hideBottomSheet = { hideBottomSheet(coroutineScope, bottomSheetState) },
                onCategorySelected = viewModel::onCategorySelected,
                onIntervalSelected = viewModel::onIntervalSelected
            )
        },
        sheetShape = MyMoneyTheme.shapes.extraLarge,
        sheetBackgroundColor = MyMoneyTheme.color.surface
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
                AddExpenseBottomBar(
                    onAddExpense = { viewModel.onAddExpense(context.resources) },
                    isEnabled = state.isButtonEnabled
                )
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
                    onClicked = {}
                )

                EditableSectionWithIcon(
                    placeHolder = stringResource(id = R.string.description),
                    label = stringResource(id = R.string.description),
                    icon = Icons.Outlined.Description,
                    iconBackgroundColor = MyMoneyTheme.color.secondaryContainer,
                    backgroundColor = MyMoneyTheme.color.secondaryContainer,
                    textColor = MyMoneyTheme.color.onSecondaryContainer,
                    cursorColor = MyMoneyTheme.color.onSecondaryContainer,
                    text = state.description.orEmpty(),
                    onTextChanged = viewModel::onDescriptionChanged
                )

                ClickableSectionWithIcon(
                    icon = state.selectedCategory?.icon ?: Icons.Outlined.Category,
                    iconBackgroundColor = state.selectedCategory?.iconBackground
                        ?: MyMoneyTheme.color.secondaryContainer,
                    text = stringResource(id = state.selectedCategory?.name ?: R.string.category),
                    label = stringResource(id = R.string.category),
                    onClicked = {
                        bottomSheetType = BottomSheetType.Categories
                        keyboardController?.hide()
                        showBottomSheet(coroutineScope, bottomSheetState)
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
                        text = state.amount.orEmpty(),
                        onTextChanged = viewModel::onAmountChanged
                    )
                    ClickableSection(
                        modifier = Modifier.weight(1f),
                        text = stringResource(id = state.selectedInterval.nameResource),
                        label = stringResource(
                            id = R.string.interval
                        ),
                        onClicked = {
                            bottomSheetType = BottomSheetType.Intervals
                            keyboardController?.hide()
                            showBottomSheet(coroutineScope, bottomSheetState)
                        }
                    )
                }
                EditableTextField(
                    modifier = Modifier.padding(horizontal = MyMoneyTheme.padding.m),
                    placeholder = stringResource(id = R.string.default_billing_day),
                    label = stringResource(id = R.string.billing_day),
                    backgroundColor = MyMoneyTheme.color.inversePrimary,
                    textColor = MyMoneyTheme.color.onPrimaryContainer,
                    cursorColor = MyMoneyTheme.color.onPrimaryContainer,
                    text = state.billingDay.orEmpty(),
                    onTextChanged = viewModel::onBillingDayChanged,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
private fun hideBottomSheet(
    coroutineScope: CoroutineScope,
    bottomSheetState: ModalBottomSheetState
) {
    coroutineScope.launch {
        bottomSheetState.hide()
    }
}

@OptIn(ExperimentalMaterialApi::class)
private fun showBottomSheet(
    coroutineScope: CoroutineScope,
    bottomSheetState: ModalBottomSheetState
) {
    coroutineScope.launch {
        bottomSheetState.show()
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
        )
    }
}
