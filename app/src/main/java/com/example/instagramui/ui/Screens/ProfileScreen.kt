package com.example.instagramui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.instagramui.data.PostsRepo
import com.example.instagramui.models.ImageWithText
import com.example.instagramui.models.Post
import com.example.instagramui.models.currentUser
import com.example.instagramui.ui.Screens.MyTopAppBar
import com.example.instagramui.ui.theme.backgroundColor
import com.example.instagramui.ui.theme.textColor
import com.example.instagramui.uicomponents.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlin.random.Random

@ExperimentalFoundationApi
@Destination
@Composable
fun ProfileScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier,
) {
    val posts by PostsRepo.posts
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        MyTopAppBar(userName = currentUser.name)
        Spacer(modifier = Modifier.height(4.dp))
        ProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        ButtonSection(modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        LazyRow {
            itemsIndexed(posts) { _, post ->
                HighlightsSection(image = rememberImagePainter(post.image),
                    text = post.caption.split(" ")[0])
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        PostTabView(
            imageWithText = listOf(
                ImageWithText(
                    image = painterResource(id = R.drawable.grid),
                    text = "Posts"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.reels),
                    text = "Reels"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.igtv),
                    text = "IGTV"
                ),
                ImageWithText(
                    image = painterResource(id = R.drawable.ic_tags),
                    text = "Profile"
                ),
            )
        ) {
            selectedTabIndex = it
        }
        when (selectedTabIndex) {
            0 -> {
                LazyVerticalGrid(
                    cells = GridCells.Fixed(3),
                    modifier = modifier
                        .scale(1.01f)
                ) {
                    itemsIndexed(posts) { _, post ->
                        PostsSection(
                            image = rememberImagePainter(post.image),
                            modifier = Modifier.fillMaxWidth()
                        )
                    }

                }
            }
        }
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
                    color = MaterialTheme.colors.textColor
                )
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "down",
                    tint = MaterialTheme.colors.textColor
                )
            }

        },
        backgroundColor = MaterialTheme.colors.backgroundColor,
        elevation = 0.dp,
//        navigationIcon = {
//            IconButton(onClick = {}) {
//                Icon(
//                    imageVector = Icons.Default.ArrowBack,
//                    contentDescription = "back",
//                    tint = Color.Black,
//
//                    )
//            }
//        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.bell_icon),
                    contentDescription = "bell",
                    tint = MaterialTheme.colors.textColor,
                    modifier = modifier.size(24.dp)

                )
            }
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(id = R.drawable.dot_menu),
                    contentDescription = "dot menu  ",
                    tint = MaterialTheme.colors.textColor,
                    modifier = modifier.size(18.dp)

                )
            }
        }
    )
}
@Composable
fun ProfileSection(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp)
        ) {
            RoundImage(
                image = painterResource(id = R.drawable.profile),
                modifier = modifier
                    .size(100.dp)
                    .weight(3f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            StatSection(
                modifier = Modifier
                    .weight(7f))

        }
        Spacer(modifier = Modifier.height(4.dp))
        ProfileDescription(
            displayName = "Android Developer",
            description = "2 Years of Coding experience\n" +
                           "Looking for Opportunities",
            url = "https://www.instagram.com/sohail__shah_/",
            followedBy = listOf("Bill gates","Mark Zukerberg"),
            otherCount = 20
        )
    }
}

@Composable
fun StatSection(
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "15", textDesc = "Posts")
        ProfileStat(numberText = Random.nextInt(500,1000).toString(), textDesc = "Followers")
        ProfileStat(numberText = Random.nextInt(50,100).toString(), textDesc = "Following")
    }
}

@Composable
fun ButtonSection(
    modifier: Modifier = Modifier
){
    val minWidth = 95.dp
    val height = 30.dp
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = modifier
            .padding(horizontal = 10.dp)
    ) {
        ActionButton(
            text = "Edit Profile",
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
        )
//        ActionButton(
//            text = "Message",
//            modifier = Modifier
//                .defaultMinSize(minWidth = minWidth)
//                .height(height)
//        )
//        ActionButton(
//            text = "Email",
//            modifier = Modifier
//                .defaultMinSize(minWidth = minWidth)
//                .height(height)
//        )
//        ActionButton(
//            icon = Icons.Default.KeyboardArrowDown,
//            modifier = Modifier
//                .size(height)
//        )
    }
}


//@ExperimentalFoundationApi
//@Composable
//@Preview
//fun testPreview(){
//    ProfileScreen()
//}