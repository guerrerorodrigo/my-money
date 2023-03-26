package com.rodrigoguerrero.mymoney.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.rodrigoguerrero.mymoney.models.Interval
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun IntervalBottomSheet(
    modifier: Modifier = Modifier,
    onIntervalSelected: (Interval) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = MyMoneyTheme.padding.l)
    ) {
        Interval.values().forEach { interval ->
            Text(
                text = stringResource(id = interval.nameResource),
                style = MyMoneyTheme.typography.labelLarge,
                color = MyMoneyTheme.color.onBackground,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onIntervalSelected(interval) }
                    .padding(vertical = MyMoneyTheme.padding.s, horizontal = MyMoneyTheme.padding.l)
            )
        }
    }
}
