package com.rodrigoguerrero.mymoney.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.components.CategoryItem
import com.rodrigoguerrero.mymoney.models.categories.expensesCategories
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun CategoriesBottomSheet(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onCategorySelected: (Int) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    end = MyMoneyTheme.padding.m,
                    top = MyMoneyTheme.padding.m
                ),
            horizontalArrangement = Arrangement.End
        ) {
            IconButton(onClick = onDismiss) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    tint = MyMoneyTheme.color.onBackground
                )
            }
        }
        Column(
            modifier = modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            expensesCategories.forEach { category ->
                CategoryItem(category = category, onCategorySelected = onCategorySelected)
            }
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewCategoryBottomSheet() {
    MyMoneyTheme {
        CategoriesBottomSheet(
            onDismiss = { },
            onCategorySelected = { }
        )
    }
}
