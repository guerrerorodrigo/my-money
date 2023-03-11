package com.rodrigoguerrero.mymoney

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.components.Movement
import com.rodrigoguerrero.mymoney.components.MovementItem
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun MovementListScreen(
    modifier: Modifier = Modifier,
    movements: List<Movement>,
    total: String
) {
    LazyColumn(
        modifier = modifier,
        state = rememberLazyListState(),
        contentPadding = PaddingValues(all = MyMoneyTheme.padding.m),
        verticalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.s)
    ) {
        item {
            Column(
                modifier = Modifier.padding(bottom = MyMoneyTheme.padding.l)
            ) {
                Text(
                    text = total,
                    style = MyMoneyTheme.typography.headlineMedium,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MyMoneyTheme.color.onSurface,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = R.string.spending_per_month),
                    style = MyMoneyTheme.typography.labelLarge,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    color = MyMoneyTheme.color.onSurface
                )
            }

        }
        items(movements) { movement ->
            MovementItem(movement = movement)
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true, backgroundColor = 0xFF201A17)
@Preview(showBackground = true, backgroundColor = 0xFFFFFBFF)
@Composable
private fun PreviewMovementListScreen() {
    MyMoneyTheme {
        val list = mutableListOf<Movement>()
        for (i in 0..50) {
            val movement = Movement(
                name = "Spotify $i",
                category = "Streaming Services",
                amount = "€14.99",
                icon = Icons.Filled.MusicNote,
                iconBackground = Color.Cyan
            )
            list.add(movement)
        }
        MovementListScreen(movements = list, total = "€1,234.99")
    }
}
