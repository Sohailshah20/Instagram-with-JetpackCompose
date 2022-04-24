package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.instagramui.destinations.Destination
import com.example.instagramui.ui.theme.backgroundColor
import com.example.instagramui.ui.theme.textColor
import com.example.instagramui.uicomponents.RoundImage
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
        backgroundColor = MaterialTheme.colors.background
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
                selectedContentColor = MaterialTheme.colors.textColor,
                unselectedContentColor = MaterialTheme.colors.textColor.copy(0.4f),
            )
        }
    }

}