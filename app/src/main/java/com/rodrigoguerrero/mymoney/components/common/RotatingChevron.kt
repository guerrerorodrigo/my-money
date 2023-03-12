package com.rodrigoguerrero.mymoney.components

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

private const val rotationDuration = 300
private const val zeroDegrees = 0f
private const val halfRotation = 180f
private const val quarterRotation = -90f

@Composable
fun RotatingChevron(
    modifier: Modifier = Modifier,
    tint: Color = Color.Black,
    shouldRotate: Boolean
) {
    val productRotationAngle by animateFloatAsState(
        targetValue = if (shouldRotate) {
            halfRotation
        } else {
            zeroDegrees
        },
        animationSpec = tween(durationMillis = rotationDuration)
    )
    Icon(
        imageVector = Icons.Filled.ChevronLeft,
        contentDescription = "",
        tint = tint,
        modifier = modifier
            .rotate(quarterRotation)
            .rotate(productRotationAngle)
    )
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewRotatingChevron() {
    MyMoneyTheme {
        RotatingChevron(shouldRotate = false)
    }
}

@Preview(name = "Dark Mode", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Preview(showBackground = true)
@Composable
private fun PreviewRotatingChevronRotated() {
    MyMoneyTheme {
        RotatingChevron(shouldRotate = true)
    }
}
