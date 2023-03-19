package com.rodrigoguerrero.mymoney.navigation

sealed class NavDestination(val destination: String) {
    object TransactionsScreenDestination : NavDestination("transactions-screen")
}
