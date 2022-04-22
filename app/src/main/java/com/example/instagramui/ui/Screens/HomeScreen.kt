package com.example.instagramui.ui.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.instagramui.models.ImageWithText
import com.example.instagramui.R
import com.example.instagramui.data.PostsRepo
import com.example.instagramui.models.Post
import com.example.instagramui.uicomponents.HighlightsSection
import com.example.instagramui.uicomponents.PostItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalFoundationApi
@Destination(
    start = true
)
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
){
    val posts by PostsRepo.posts
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HomeScreenTopAppBar()
        Spacer(modifier = Modifier.height(4.dp))
        HighlightsSection(
        highlights = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.twitter),
                text = "Elon Musk"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.instagram),
                text = "Jack Dorsey"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.whatsapp),
                text = "Sundar"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.snapchat),
                text = "Jeff Bezos"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.reddit),
                text = "Reddit"
            )
        ),
        modifier = Modifier
            .fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(10.dp))
        Divider(thickness = 0.5.dp)
        LazyColumn{
            itemsIndexed(posts){ _, post ->
                PostItem(post = post)
            }
        }
    }
    
}

@Composable
fun HomeScreenTopAppBar(
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Row{
                Icon(
                    painter = painterResource(id = com.example.instagramui.R.drawable.ic_ig_logo),
                    contentDescription = "bell",
                    tint = Color.Black,
                    modifier = modifier.size(100.dp)

                )
            }

        },
        backgroundColor = Color.White,
        elevation = 0.dp,
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = com.example.instagramui.R.drawable.ic_add),
                    contentDescription = "bell",
                    tint = Color.Black,
                    modifier = modifier.size(24.dp)

                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = com.example.instagramui.R.drawable.ic_messenger),
                    contentDescription = "dot menu  ",
                    tint = Color.Black,
                    modifier = modifier.size(24.dp)

                )
            }
        }
    )
}

//@ExperimentalFoundationApi
//@Preview
//@Composable
//fun homeScreenPreview(){
//    HomeScreen(navigator = )
//}


