package com.berliana.taskfrontendil.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailDrink : Screen("home/{drinkId}") {
        fun createRoute(drinkId: Long) = "home/$drinkId"
    }
}