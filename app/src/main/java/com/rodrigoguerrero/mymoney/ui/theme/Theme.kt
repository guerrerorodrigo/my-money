package com.rodrigoguerrero.mymoney.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.rodrigoguerrero.mymoney.ui.theme.colors.DarkColors
import com.rodrigoguerrero.mymoney.ui.theme.colors.LightColors
import com.rodrigoguerrero.mymoney.ui.theme.colors.LocalMyMoneyColors

object MyNotesTheme {
    val color: ColorScheme
        @Composable
        get() = LocalMyMoneyColors.current

    val padding: MyMoneyPadding
        @Composable
        get() = LocalMyMoneyPadding.current

    val typography: Typography
        @Composable
        get() = LocalMyMoneyTypography.current

    val shapes: Shapes
        @Composable
        get() = LocalMyMoneyShapes.current
}

@Composable
fun MyMoneyTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    val padding = MyMoneyPadding()
    val typography = typography()

    CompositionLocalProvider(
        LocalMyMoneyColors provides colors,
        LocalMyMoneyPadding provides padding,
        LocalMyMoneyTypography provides typography,
        LocalMyMoneyShapes provides Shapes
    ) {
        MaterialTheme(
            colorScheme = colors,
            shapes = Shapes,
            typography = typography
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                content()
            }
        }
    }
}
