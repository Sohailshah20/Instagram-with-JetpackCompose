package com.example.instagramui.ui.Screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramui.R
import com.example.instagramui.models.ImageWithText
import com.example.instagramui.uicomponents.*
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@ExperimentalFoundationApi
@Destination
@Composable
fun UserProfileScreen(
    navigator: DestinationsNavigator,
    modifier: Modifier = Modifier
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    val state = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(state)
    ) {
        MyTopAppBar(userName = "Random User")
        Spacer(modifier = modifier.height(4.dp))
        UserProfileSection()
        Spacer(modifier = Modifier.height(25.dp))
        UserButtonSection(modifier =  Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(25.dp))
        HighlightsSection(highlights = listOf(
            ImageWithText(
                image = painterResource(id = R.drawable.twitter),
                text = "Twitter"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.instagram),
                text = "Instagram"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.whatsapp),
                text = "Whatsapp"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.snapchat),
                text = "Snapchat"
            ),
            ImageWithText(
                image = painterResource(id = R.drawable.reddit),
                text = "Reddit"
            )
        ),
            modifier = Modifier
                .fillMaxWidth()
        )
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
                    image = painterResource(id = R.drawable.profile),
                    text = "Profile"
                ),
            )
        ){
            selectedTabIndex = it
        }
        when(selectedTabIndex){
            0 -> PostsSection(
                posts = listOf(
                    painterResource(id = R.drawable.profile),
                    painterResource(id = R.drawable.post1),
                    painterResource(id = R.drawable.post2),
                    painterResource(id = R.drawable.post3),
                    painterResource(id = R.drawable.post4),
                    painterResource(id = R.drawable.post5),
                    painterResource(id = R.drawable.post6),
                    painterResource(id = R.drawable.post7),
                    painterResource(id = R.drawable.post8),
                    painterResource(id = R.drawable.post9),
                    painterResource(id = R.drawable.post10),
                    painterResource(id = R.drawable.post11),
                    painterResource(id = R.drawable.post12),
                    painterResource(id = R.drawable.post13),
                    painterResource(id = R.drawable.post14),
                ),
                modifier = Modifier.fillMaxWidth()
            )
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
                )
//                Icon(
//                    imageVector = Icons.Default.ArrowDropDown,
//                    contentDescription = "down"
//                )
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
                    painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                    contentDescription = "dot menu  ",
                    tint = Color.Black,
                    modifier = modifier.size(18.dp)

                )
            }
        }
    )
}

@Composable
fun UserProfileSection(
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
            UserStatSection(
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
fun UserStatSection(
    modifier: Modifier = Modifier
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        ProfileStat(numberText = "40", textDesc = "Posts")
        ProfileStat(numberText = "1325", textDesc = "Followers")
        ProfileStat(numberText = "69", textDesc = "Following")
    }
}

@Composable
fun UserButtonSection(
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
            text = "Following",
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Message",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            text = "Email",
            modifier = Modifier
                .defaultMinSize(minWidth = minWidth)
                .height(height)
        )
        ActionButton(
            icon = Icons.Default.KeyboardArrowDown,
            modifier = Modifier
                .size(height)
        )
    }
}


//@ExperimentalFoundationApi
//@Composable
//@Preview
//fun testPreview(){
//    UserProfileScreen()
//}
