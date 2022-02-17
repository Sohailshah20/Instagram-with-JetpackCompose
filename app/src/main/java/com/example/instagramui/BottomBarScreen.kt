package com.example.instagramui

import androidx.compose.ui.res.painterResource


sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: Int
){
    object Home : BottomBarScreen(
        route = "Home",
        title = "Home",
        icon = R.drawable.ic_home
    )
    object Search : BottomBarScreen(
        route = "Search",
        title = "Search",
        icon = R.drawable.ic_search
    )
    object Reels : BottomBarScreen(
        route = "Reels",
        title = "Reels",
        icon = R.drawable.ic_reels
    )
    object Activity : BottomBarScreen(
        route = "Activity",
        title = "Activity",
        icon = R.drawable.ic_heart
    )
    object Profile : BottomBarScreen(
        route = "Profile",
        title = "Profile",
        icon = R.drawable.ic_home
    )

}