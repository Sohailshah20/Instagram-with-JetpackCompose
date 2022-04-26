package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.rememberImagePainter
import com.example.instagramui.destinations.Destination
import com.example.instagramui.models.currentUser
import com.example.instagramui.ui.theme.backgroundColor
import com.example.instagramui.ui.theme.textColor
import com.example.instagramui.uicomponents.RoundImage
import com.ramcosta.composedestinations.navigation.navigateTo

@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(
    navController: NavController,
    currentScreen: BottomBarDestinations
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
            val selected = destination == currentScreen
            val icon = if (selected) destination.selectedIcon else destination.icon
//            val selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true
            BottomNavigationItem(
                selected = currentDestination == destination.direction,
                onClick = {
                    navController.navigateTo(destination.direction){
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if(destination == BottomBarDestinations.Profile){
                        RoundImage(rememberImagePainter(currentUser.image),
                                    modifier= Modifier.size(30.dp))
                    }else {
                            Icon(painterResource(icon),
                                contentDescription = destination.title)
                        }
                },
                selectedContentColor = MaterialTheme.colors.textColor,
                unselectedContentColor = MaterialTheme.colors.textColor.copy(0.4f)
            )
        }
    }

}

//@Composable
//private fun BottomBarProfile(isSelected: Boolean) {
//        Box(
//            modifier = Modifier
//                .padding(padding)
//
//        ) {
//            RoundImage(rememberImagePainter(currentUser.image))
//        }
//
//
//}
