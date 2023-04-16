package com.rodrigoguerrero.mymoney.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rodrigoguerrero.mymoney.R
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

@Composable
fun EmptyTransactionList(
    modifier: Modifier = Modifier,
    description: String
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.empty))
    val progress by animateLottieCompositionAsState(composition = composition)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize(),
    ) {
        LottieAnimation(
            composition = composition,
            progress = { progress },
            modifier = Modifier
                .padding(bottom = MyMoneyTheme.padding.m)
                .height(dimensionResource(R.dimen.animation_height))
        )
        Text(
            text = description,
            style = MyMoneyTheme.typography.labelLarge.copy(color = MyMoneyTheme.color.onBackground),
            modifier = Modifier.padding(bottom = MyMoneyTheme.padding.m)
        )
    }
}
