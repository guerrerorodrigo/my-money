package com.rodrigoguerrero.mymoney.components.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CreditCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.components.TransactionTypeIcon
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun EditableSectionWithIcon(
    modifier: Modifier = Modifier,
    placeHolder: String,
    label: String,
    icon: ImageVector,
    iconBackgroundColor: Color,
    backgroundColor: Color,
    textColor: Color,
    cursorColor: Color
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = MyMoneyTheme.padding.m),
        horizontalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.m),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TransactionTypeIcon(
            backgroundColor = iconBackgroundColor,
            icon = icon,
            size = dimensionResource(id = R.dimen.expense_icon_size)
        )
        EditableTextField(
            placeholder = placeHolder,
            label = label,
            backgroundColor = backgroundColor,
            textColor = textColor,
            cursorColor = cursorColor
        )
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewEditableSectionWithIcon() {
    MyMoneyTheme {
        EditableSectionWithIcon(
            icon = Icons.Default.CreditCard,
            iconBackgroundColor = Color(0xFF9C27B0),
            placeHolder = "Placeholder",
            label = "Label",
            backgroundColor = Color.Gray,
            textColor = Color.Black,
            cursorColor = Color.Black
        )
    }
}
