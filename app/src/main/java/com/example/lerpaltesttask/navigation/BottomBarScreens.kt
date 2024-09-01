package com.example.lerpaltesttask.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreens(
    val route: String,
    val title:String,
    val unselectedIcon:ImageVector,
    val selectedIcon:ImageVector
) {
    data object FirstScreen: BottomBarScreens(
        route = Routes.FIRST_SCREEN,
        title = "1",
        unselectedIcon = Icons.Outlined.Home,
        selectedIcon = Icons.Filled.Home
    )

    data object SecondScreen: BottomBarScreens(
        route = Routes.SECOND_SCREEN,
        title = "2",
        unselectedIcon = Icons.Outlined.Star,
        selectedIcon = Icons.Filled.Star
    )

}