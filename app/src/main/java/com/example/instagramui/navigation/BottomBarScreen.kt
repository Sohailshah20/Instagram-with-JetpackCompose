@file:OptIn(ExperimentalFoundationApi::class)

package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.instagramui.destinations.*
import com.ramcosta.composedestinations.spec.NavGraphSpec


enum class BottomBarDestinations(
    val direction: DirectionDestination,
    val title: String,
    val icon: Int
){
    Home(
        direction = HomeScreenDestination,
        title = "Home",
        icon = R.drawable.ic_home
    ),
    Search(
        direction = SearchScreenDestination,
        title = "Search",
        icon = R.drawable.ic_search
    ),
    Reels(
        direction = ReelsScreenDestination,
        title = "Reels",
        icon = R.drawable.ic_reels
    ),
    Activity(
        direction = ActivityScreenDestination,
        title = "Activity",
        icon = R.drawable.ic_heart
    ),
    Profile(
        direction = ProfileScreenDestination,
        title = "Profile",
        icon = R.drawable.ic_home
    )

}