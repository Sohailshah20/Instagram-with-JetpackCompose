package com.example.instagramui.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.instagramui.R
import com.example.instagramui.data.Post
import com.example.instagramui.ui.theme.textColor

@Composable
fun PostItem(

){

}

@Composable
fun PostTopBar(
    modifier: Modifier = Modifier,
    image: Painter
//    posts: List<Post> 
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = modifier.width(5.dp))
        RoundImage(
            modifier = modifier
                .size(30.dp)
                .weight(1f)
                ,
            image = image  
        )
        Text(
            text = "userName",
            modifier = modifier
                .weight(8f)
                .padding(start = 5.dp)
        )
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(R.drawable.ic_baseline_more_horiz_24),
                contentDescription = "menu",
            tint = MaterialTheme.colors.textColor)
        }
        
        
    }
}

@Composable
fun PostActionsRow(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = modifier
                .fillMaxSize()
        ) {
            Row(
                modifier = modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_heart),
                        contentDescription = "menu",
                        modifier = modifier
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_comment),
                        contentDescription = "menu",
                        modifier = modifier
                    )
                }
                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.ic_share),
                        contentDescription = "menu",
                        modifier = modifier
                    )
                }
                Row(
                    modifier = modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {

                }
                Row(
                    modifier = modifier
                        .fillMaxHeight()
                        .weight(1f),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_bookmark),
                            contentDescription = "menu",

                        )
                    }
                }

            }
        }
    }
}

@Composable
fun PostLikesCount(
    modifier: Modifier = Modifier,
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(30.dp)
            .padding(horizontal = 10.dp)
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "100 likes",
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.textColor
        )
    }
}

@Composable
fun PostCaption(
    modifier: Modifier = Modifier,
    description: String
){
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 10.dp)
        ,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = buildAnnotatedString {
                val boldStyle = SpanStyle(
                    color = MaterialTheme.colors.textColor,
                    fontWeight = Bold)
                val normalStyle = SpanStyle(
                    color = MaterialTheme.colors.textColor,
                    fontWeight = Normal
                )
                pushStyle(boldStyle)
                append("Username")
                append(" ")
                if (description.isNotEmpty()){
                    pushStyle(normalStyle)
                    append("this is the description this is the description this is the description this is the description")
                }
            }
        )
    }
}

@Preview(backgroundColor = 0xFFFFFFF)
@Composable
fun postTest(){
    PostCaption(description = "this is the description this is the description this is the description this is the description")
}