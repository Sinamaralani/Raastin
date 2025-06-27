package com.example.raastin.core.presentation.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.raastin.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.raastin.core.presentation.theme.IranSansX

@Composable
fun BottomNavigationBar(
    navController: NavController
) {

    val items = listOf(
        BottomItems(
            label = "پروفایل",
            selectedIcon = R.drawable.person_24dp_fill,
            unSelectedIcon = R.drawable.person_24px,
            screen = Screen.Profile

        ),
        BottomItems(
            label = "کیف پول",
            selectedIcon = R.drawable.account_balance_wallet_24dp_fill,
            unSelectedIcon = R.drawable.account_balance_wallet_24px,
            screen = Screen.Wallet
        ),

        BottomItems(
            label = "معامله",
            selectedIcon = R.drawable.compare_arrows_24px,
            unSelectedIcon = R.drawable.compare_arrows_24px,
            screen = Screen.Trade
        ),
        BottomItems(
            label = "بازارها",
            selectedIcon = R.drawable.trending_up_24px,
            unSelectedIcon = R.drawable.trending_up_24px,
            screen = Screen.Markets
        ),
        BottomItems(
            label = "خانه",
            selectedIcon = R.drawable.home_24dp_fill,
            unSelectedIcon = R.drawable.home_24px,
            screen = Screen.Home
        ),
    )
    var selectedItems by rememberSaveable {
        mutableIntStateOf(4)
    }

    NavigationBar {
        items.forEachIndexed { index, items ->

            NavigationBarItem(
                selected = selectedItems == index,
                onClick = {
                    selectedItems = index
                    navigateToTab(navController, items.screen)
                },
                icon = {
                    Icon(
                        painter = painterResource(id = if (selectedItems == index) items.selectedIcon else items.unSelectedIcon),
                        contentDescription = items.label,
                    )
                },
                label = { Text(items.label, fontFamily = IranSansX) },
                colors = NavigationBarItemDefaults.colors(
                    unselectedTextColor = Color.Gray,
                    unselectedIconColor = Color.Gray,
                    indicatorColor = Color.Transparent,
                ),
                alwaysShowLabel = true,
            )
        }
    }
}

private fun navigateToTab(navController: NavController, route: Screen) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let { screenRoute ->
            popUpTo(screenRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}



