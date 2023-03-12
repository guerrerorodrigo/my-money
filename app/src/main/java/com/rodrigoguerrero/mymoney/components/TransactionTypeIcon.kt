package com.rodrigoguerrero.mymoney.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MusicNote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun TransactionTypeIcon(
    modifier: Modifier = Modifier,
    backgroundColor: Color,
    icon: ImageVector
) {
    Surface(
        modifier = modifier
            .clip(CircleShape)
            .size(dimensionResource(id = R.dimen.icon_container_size)),
        color = backgroundColor
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier
                .size(dimensionResource(id = R.dimen.icon_size))
                .padding(all = MyMoneyTheme.padding.xs)
        )
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewTransactionTypeIcon() {
    MyMoneyTheme {
        TransactionTypeIcon(
            backgroundColor = MyMoneyTheme.color.inversePrimary,
            icon = Icons.Filled.MusicNote
        )
    }
}
