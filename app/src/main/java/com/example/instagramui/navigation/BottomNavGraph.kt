package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.instagramui.destinations.Destination
import com.ramcosta.composedestinations.navigation.navigateTo

@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(
    navController: NavController
){
    val currentDestination: Destination? = navController.currentBackStackEntryAsState()
        .value?.navDestination
    BottomNavigation(
                modifier = Modifier
            .height(46.dp),
        backgroundColor = Color.White,
        )
    {
        BottomBarDestinations.values().forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigateTo(destination.direction){
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(painterResource(destination.icon),
                        contentDescription = destination.title)
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
            )
        }
    }

}