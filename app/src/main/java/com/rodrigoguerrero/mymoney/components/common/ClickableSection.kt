package com.rodrigoguerrero.mymoney.components.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun ClickableSection(
    modifier: Modifier = Modifier,
    text: String,
    label: String,
    onClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.s)
    ) {
        Text(
            text = label,
            style = MyMoneyTheme.typography.labelMedium,
            fontWeight = FontWeight.Bold,
            color = MyMoneyTheme.color.onPrimaryContainer
        )
        Surface(
            modifier = Modifier.clickable { onClicked() },
            shape = MyMoneyTheme.shapes.medium,
            color = MyMoneyTheme.color.inversePrimary,
            contentColor = MyMoneyTheme.color.onPrimary
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(MyMoneyTheme.padding.s)
            ) {
                Text(
                    text = text,
                    style = MyMoneyTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f),
                    color = MyMoneyTheme.color.onPrimaryContainer
                )
                Icon(
                    imageVector = Icons.Default.ChevronLeft,
                    tint = MyMoneyTheme.color.onPrimaryContainer,
                    contentDescription = null,
                    modifier = Modifier.rotate(-90f)
                )
            }
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewClickableSection() {
    MyMoneyTheme {
        ClickableSection(text = "Click Me", label = "Label", onClicked = { })
    }
}
