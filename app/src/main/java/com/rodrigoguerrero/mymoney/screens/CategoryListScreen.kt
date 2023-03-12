package com.rodrigoguerrero.mymoney.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.components.CategoryItem
import com.rodrigoguerrero.mymoney.models.Category
import com.rodrigoguerrero.mymoney.models.categories.expensesCategories
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onClose: () -> Unit,
    onCategorySelected: (Int) -> Unit
) {
    Scaffold(
        modifier = modifier.fillMaxHeight(),
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = onClose) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = null,
                        tint = MyMoneyTheme.color.onSurface
                    )
                }
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            itemsIndexed(categories) { index, category ->
                CategoryItem(category = category, onCategorySelected = onCategorySelected)
                if (index != categories.size - 1) {
                    Divider(color = MyMoneyTheme.color.outlineVariant)
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
private fun PreviewCategoryListScreen() {
    MyMoneyTheme {
        CategoryListScreen(
            categories = expensesCategories,
            onClose = { },
            onCategorySelected = { }
        )
    }
}
