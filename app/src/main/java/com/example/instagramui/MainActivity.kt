package com.example.instagramui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import com.ramcosta.composedestinations.DestinationsNavHost

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Scaffold(
                bottomBar = {
                    BottomNavGraph(navController)
                }
            ) {
                DestinationsNavHost(
                    navController = navController,
                    navGraph = NavGraphs.root

                )
            }
            }
        }
    }

