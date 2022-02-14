package com.example.instagramui.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramui.R

@Composable
fun UserProfileScreen(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

    }
}

@Composable
fun MyTopAppBar(
    userName: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row{
                Text(
                    text = userName,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "down"
                )
            }

        },
        backgroundColor = Color.White,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back",
                    tint = Color.Black,

                    )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.bell_icon),
                    contentDescription = "bell",
                    tint = Color.Black,
                    modifier = modifier.size(24.dp)

                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.dot_menu),
                    contentDescription = "dot menu  ",
                    tint = Color.Black,
                    modifier = modifier.size(18.dp)

                )
            }
        }
    )
}
