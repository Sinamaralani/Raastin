package com.example.raastin.core.presentation.navigation

sealed interface Screen {

    @kotlinx.serialization.Serializable
    data object Home : Screen

    @kotlinx.serialization.Serializable
    data object Markets : Screen

    @kotlinx.serialization.Serializable
    data object Trade : Screen

    @kotlinx.serialization.Serializable
    data object Wallet : Screen

    @kotlinx.serialization.Serializable
    data object Profile : Screen

}