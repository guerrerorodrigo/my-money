package com.rodrigoguerrero.mymoney.components

import androidx.compose.runtime.Composable
import com.rodrigoguerrero.mymoney.models.BottomSheetType
import com.rodrigoguerrero.mymoney.models.Interval
import com.rodrigoguerrero.mymoney.screens.CategoriesBottomSheet
import com.rodrigoguerrero.mymoney.screens.IntervalBottomSheet

@Composable
fun AddExpensesBottomSheets(
    bottomSheetType: BottomSheetType,
    hideBottomSheet: () -> Unit,
    onCategorySelected: (Int) -> Unit,
    onIntervalSelected: (Interval) -> Unit
) {
    when (bottomSheetType) {
        BottomSheetType.Categories -> CategoriesBottomSheet(
            onDismiss = hideBottomSheet,
            onCategorySelected = { id ->
                onCategorySelected(id)
                hideBottomSheet()
            }
        )
        BottomSheetType.Intervals -> IntervalBottomSheet(
            onIntervalSelected = { interval ->
                onIntervalSelected(interval)
                hideBottomSheet()
            }
        )
    }
}
