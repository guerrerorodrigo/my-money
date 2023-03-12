package com.rodrigoguerrero.mymoney.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.components.common.ExpandableSection
import com.rodrigoguerrero.mymoney.components.common.RotatingChevron
import com.rodrigoguerrero.mymoney.models.Category
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun CategoryItem(
    modifier: Modifier = Modifier,
    category: Category,
    onCategorySelected: (Int) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val hasSubcategories by remember { mutableStateOf(category.subcategories.isNotEmpty()) }

    Column {
        Row(
            modifier = modifier
                .clickable {
                    if (hasSubcategories) {
                        isExpanded = !isExpanded
                    } else {
                        onCategorySelected(category.id)
                    }
                }
                .padding(all = MyMoneyTheme.padding.ml),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.m)
        ) {
            TransactionTypeIcon(backgroundColor = category.iconBackground, icon = category.icon)
            Text(
                text = stringResource(id = category.name),
                style = MyMoneyTheme.typography.labelMedium,
                color = MyMoneyTheme.color.onSurface,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f)
            )

            if (hasSubcategories) {
                RotatingChevron(shouldRotate = isExpanded, tint = MyMoneyTheme.color.outlineVariant)
            }
        }

        ExpandableSection(isExpanded = isExpanded) {
            Column {
                category.subcategories.forEach { subcategory ->
                    Text(
                        text = stringResource(id = subcategory.name),
                        style = MyMoneyTheme.typography.labelMedium,
                        color = MyMoneyTheme.color.onSurface,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { onCategorySelected(subcategory.id) }
                            .padding(
                                start = dimensionResource(id = R.dimen.subcategory_padding),
                                end = MyMoneyTheme.padding.m,
                                top = MyMoneyTheme.padding.m,
                                bottom = MyMoneyTheme.padding.m
                            )

                    )
                }
            }
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewCategoryItem() {
    MyMoneyTheme {
        val category = Category(
            id = 1,
            icon = Icons.Filled.SportsSoccer,
            iconBackground = Color.Cyan,
            name = R.string.category_entertainment,
            subcategories = emptyList()
        )
        CategoryItem(category = category, onCategorySelected = { })
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewCategoryItemWithSubcategory() {
    MyMoneyTheme {
        val category = Category(
            id = 1,
            icon = Icons.Filled.SportsSoccer,
            iconBackground = Color.Cyan,
            name = R.string.category_entertainment,
            subcategories = emptyList()
        )
        CategoryItem(
            category = category.copy(
                subcategories = listOf(
                    category,
                    category.copy(name = R.string.category_entertainment),
                    category,
                    category
                )
            ),
            onCategorySelected = { }
        )
    }
}
