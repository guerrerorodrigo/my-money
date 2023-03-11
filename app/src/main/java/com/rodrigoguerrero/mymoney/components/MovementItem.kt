package com.rodrigoguerrero.mymoney.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun MovementItem(
    modifier: Modifier = Modifier,
    movement: Movement
) {
    Card(
        modifier = modifier,
        shape = MyMoneyTheme.shapes.medium,
        elevation = dimensionResource(id = R.dimen.card_elevation),
        backgroundColor = MyMoneyTheme.color.surfaceVariant
    ) {
        Row(
            modifier = Modifier
                .padding(all = MyMoneyTheme.padding.m),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MyMoneyTheme.padding.m)
        ) {
            Surface(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(dimensionResource(id = R.dimen.icon_container_size)),
                color = movement.iconBackground
            ) {
                Icon(
                    imageVector = movement.icon,
                    contentDescription = null,
                    modifier = Modifier
                        .size(dimensionResource(id = R.dimen.icon_size))
                        .padding(all = MyMoneyTheme.padding.xs)
                )
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = movement.name,
                    style = MyMoneyTheme.typography.labelMedium,
                    color = MyMoneyTheme.color.onSurface,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = movement.category,
                    style = MyMoneyTheme.typography.labelSmall,
                    color = MyMoneyTheme.color.onSurface
                )
            }
            Text(
                text = movement.amount,
                style = MyMoneyTheme.typography.labelLarge,
                color = MyMoneyTheme.color.onSurface,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewMovementItem() {
    MyMoneyTheme {
        val movement = Movement(
            name = "Spotify",
            category = "Streaming Services",
            amount = "€14.99",
            icon = Icons.Filled.MusicNote,
            iconBackground = Color.Cyan
        )

        MovementItem(movement = movement)
    }
}
