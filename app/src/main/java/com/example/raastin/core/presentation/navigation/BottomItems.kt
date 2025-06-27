package com.example.raastin.core.presentation.navigation

import androidx.annotation.DrawableRes

data class BottomItems(
    val label: String,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int,
    val screen: Screen
)
