package com.example.raastin.core.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.raastin.home.HomeScreen
import com.example.raastin.markets.MarketsScreen
import com.example.raastin.profile.ProfileScreen
import com.example.raastin.trade.TradeScreen
import com.example.raastin.wallet.WalletScreen


@Composable
fun Navigation() {

    val navController = rememberNavController()


    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) }
    ) {

        val bottomPadding = it.calculateBottomPadding()

        NavHost(
            modifier = Modifier
                .statusBarsPadding()
                .padding(bottom = bottomPadding),
            navController = navController,
            startDestination = Screen.Home
        ) {

            composable<Screen.Home> {
                HomeScreen()
            }

            composable<Screen.Markets> {
                MarketsScreen()
            }

            composable<Screen.Trade> {
                TradeScreen()
            }

            composable<Screen.Wallet> {
                WalletScreen()
            }

            composable<Screen.Profile> {
                ProfileScreen()
            }

        }
    }

}


