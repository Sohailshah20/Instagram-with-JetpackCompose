package com.example.instagramui.ui.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.instagramui.BottomBarDestinations
import com.example.instagramui.BottomNavGraph
import com.example.instagramui.NavGraphs
import com.example.instagramui.destinations.Destination
import com.ramcosta.composedestinations.DestinationsNavHost

@OptIn(ExperimentalFoundationApi::class)
@com.ramcosta.composedestinations.annotation.Destination
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    val screenState = remember{ mutableStateOf(BottomBarDestinations.Home)}
    Scaffold(
        bottomBar = {
            BottomNavGraph(
                navController,
                currentScreen = screenState.value
            )
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding)){
        DestinationsNavHost(
            navController = navController,
            navGraph = NavGraphs.root
        )
        }
    }
}