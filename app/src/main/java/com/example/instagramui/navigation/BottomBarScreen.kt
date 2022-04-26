@file:OptIn(ExperimentalFoundationApi::class)

package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.instagramui.destinations.*
import com.ramcosta.composedestinations.spec.NavGraphSpec


enum class BottomBarDestinations(
    val direction: DirectionDestination,
    val title: String,
    val icon: Int,
    val selectedIcon: Int,
){
    Home(
        direction = HomeScreenDestination,
        title = "Home",
        icon = R.drawable.ic_home,
        selectedIcon = R.drawable.ic_home_filled
    ),
    Search(
        direction = SearchScreenDestination,
        title = "Search",
        icon = R.drawable.ic_search,
        selectedIcon = R.drawable.ic_search_filled
    ),
    Reels(
        direction = ReelsScreenDestination,
        title = "Reels",
        icon = R.drawable.ic_reels,
        selectedIcon = R.drawable.ic_reels_filled
    ),
    Activity(
        direction = ActivityScreenDestination,
        title = "Activity",
        icon = R.drawable.ic_heart,
        selectedIcon = R.drawable.ic_activity_filled
    ),
    Profile(
        direction = ProfileScreenDestination,
        title = "Profile",
        icon = R.drawable.ic_home,
        selectedIcon = R.drawable.ic_home
    )

}