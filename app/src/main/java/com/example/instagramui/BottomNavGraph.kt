package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagramui.Screens.ActivityScreen
import com.example.instagramui.Screens.HomeFeedScreen
import com.example.instagramui.Screens.ReelsScreen
import com.example.instagramui.Screens.SearchScreen

@ExperimentalFoundationApi
@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeFeedScreen()
        }
        composable(route = BottomBarScreen.Search.route){
            SearchScreen()
        }
        composable(route = BottomBarScreen.Reels.route){
            ReelsScreen()
        }
        composable(route = BottomBarScreen.Activity.route){
            ActivityScreen()
        }
        composable(route = BottomBarScreen.Profile.route){
            ProfileScreen()
        }
    }
}