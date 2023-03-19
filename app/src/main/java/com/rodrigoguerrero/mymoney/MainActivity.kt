package com.rodrigoguerrero.mymoney

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigoguerrero.mymoney.navigation.NavDestination.TransactionsScreenDestination
import com.rodrigoguerrero.mymoney.screens.TransactionsScreen
import com.rodrigoguerrero.mymoney.theme.MyMoneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMoneyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MyMoneyTheme.color.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = TransactionsScreenDestination.destination
                    ) {
                        composable(route = TransactionsScreenDestination.destination) {
                            TransactionsScreen()
                        }
                    }
                }
            }
        }
    }
}