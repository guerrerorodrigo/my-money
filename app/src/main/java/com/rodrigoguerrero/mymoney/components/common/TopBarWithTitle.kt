package com.rodrigoguerrero.mymoney.components.common

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun TopBarWithTitle(
    modifier: Modifier = Modifier,
    title: String,
    onBack: () -> Unit,
    onClose: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(MyMoneyTheme.padding.m),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.m)
    ) {
        IconButton(onClick = onBack) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = MyMoneyTheme.color.onSurface
            )
        }
        Text(
            text = title,
            style = MyMoneyTheme.typography.titleMedium,
            color = MyMoneyTheme.color.onSurface,
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center
        )
        IconButton(onClick = onClose) {
            Icon(
                imageVector = Icons.Default.Close,
                contentDescription = null,
                tint = MyMoneyTheme.color.onSurface
            )
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewTopBarWithTitle() {
    MyMoneyTheme {
        TopBarWithTitle(title = "Title", onBack = { }, onClose = { })
    }
}
