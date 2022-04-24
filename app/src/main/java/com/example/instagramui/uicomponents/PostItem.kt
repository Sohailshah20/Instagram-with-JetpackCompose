 package com.example.instagramui.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.instagramui.R
import com.example.instagramui.models.Post
import com.example.instagramui.models.User
import com.example.instagramui.ui.theme.lightGrey
import com.example.instagramui.ui.theme.textColor

@Composable
fun PostItem(
    post: Post
){
    Column{
        Divider(thickness = 0.5.dp)
        PostTopBar(post = post)
        PostImage(post = post)
        PostActionsRow()
        PostLikesCount(post = post)
        PostCaption(post = post)
        Spacer(modifier = Modifier.height(2.dp))
        PostCommentsCount(post = post)
        Spacer(modifier = Modifier.height(4.dp))
        PostTimeStamp(post = post)
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun PostTopBar(
    modifier: Modifier = Modifier,
    post: Post
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
                .size(40.dp)
                .weight(1f)
                ,
            image = rememberImagePainter(post.user.image)
        )
        Text(
            text = post.user.name,
            modifier = modifier
                .weight(8f)
                .padding(start = 10.dp),
            fontWeight = FontWeight.Bold
        )
        IconButton(onClick = { }) {
            Icon(
                painter = painterResource(R.drawable.dot_menu),
                contentDescription = "menu",
            tint = MaterialTheme.colors.textColor)
        }


    }

}

@Composable
fun PostActionsRow(
    modifier: Modifier = Modifier,
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
                    .weight(1f)
                    ,
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
fun PostImage (
    modifier: Modifier = Modifier,
    post: Post
){
    Box(
        modifier = modifier
            .fillMaxHeight()
            .height(300.dp),
        contentAlignment = Alignment.Center,

    ) {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = rememberImagePainter(post.image),
            contentDescription = null
        )
    }
}

@Composable
fun PostLikesCount(
    modifier: Modifier = Modifier,
    post: Post
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
            text = post.likesCount.toString().plus(" likes"),
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.textColor,
            fontSize = 16.sp
        )
    }
}

@Composable
fun PostCaption(
    modifier: Modifier = Modifier,
    post: Post
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
                    fontWeight = Bold,
                    fontSize = 14.sp
                )
                val normalStyle = SpanStyle(
                    color = MaterialTheme.colors.textColor,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
                pushStyle(boldStyle)
                append(post.user.name)
                append(" ")
                if (post.caption.isNotEmpty()){
                    pushStyle(normalStyle)
                    append(post.caption)
                }
            }
        )
    }
}

 @Composable
 fun PostCommentsCount(
     modifier: Modifier = Modifier,
     post: Post
 ) {
     Row(
         modifier = modifier
             .fillMaxWidth()
             .wrapContentHeight()
             .padding(horizontal = 10.dp),
         verticalAlignment = Alignment.CenterVertically
     ) {
         Text(
             text = "View all ${post.commentsCount} comments",
             color = MaterialTheme.colors.lightGrey,
             fontWeight = FontWeight.Normal,
             fontSize = 14.sp
         )
     }

 }

 @Composable
 fun PostTimeStamp(
     modifier: Modifier = Modifier,
     post: Post
 ) {
     Row(
         modifier = modifier
             .fillMaxWidth()
             .wrapContentHeight()
             .padding(horizontal = 10.dp),
         verticalAlignment = Alignment.CenterVertically
     ) {
         Text(
             text = "${post.timeStamp} hours ago ",
             color = MaterialTheme.colors.lightGrey,
             fontSize = 10.sp,
             fontWeight = FontWeight.Light
         )
     }

 }

//@Composable
//fun ExpandableText(
//    text: String,
//    modifier: Modifier = Modifier,
//    minimizedMaxLines: Int = 2,
//) {
//
//    var cutText by remember(text) { mutableStateOf<String?>(null) }
//    var expanded by remember { mutableStateOf(false) }
//    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
//    val seeMoreSizeState = remember { mutableStateOf<IntSize?>(null) }
//    val seeMoreOffsetState = remember { mutableStateOf<Offset?>(null) }
//
//    // getting raw values for smart cast
//    val textLayoutResult = textLayoutResultState.value
//    val seeMoreSize = seeMoreSizeState.value
//    val seeMoreOffset = seeMoreOffsetState.value
//
//    LaunchedEffect(text, expanded, textLayoutResult, seeMoreSize) {
//        val lastLineIndex = minimizedMaxLines - 1
//        if (!expanded && textLayoutResult != null && seeMoreSize != null
//            && lastLineIndex + 1 == textLayoutResult.lineCount
//            && textLayoutResult.isLineEllipsized(lastLineIndex)
//        ) {
//            var lastCharIndex = textLayoutResult.getLineEnd(lastLineIndex, visibleEnd = true) + 1
//            var charRect: Rect
//            do {
//                lastCharIndex -= 1
//                charRect = textLayoutResult.getCursorRect(lastCharIndex)
//            } while (
//                charRect.left > textLayoutResult.size.width - seeMoreSize.width
//            )
//            seeMoreOffsetState.value = Offset(charRect.left, charRect.bottom - seeMoreSize.height)
//            cutText = text.substring(startIndex = 0, endIndex = lastCharIndex)
//        }
//    }
//
//    Box(modifier = modifier
//            .padding(horizontal = 10.dp)
//    ) {
//        Text(
//            text = cutText ?: text,
//            maxLines = if (expanded) Int.MAX_VALUE else minimizedMaxLines,
//            overflow = TextOverflow.Ellipsis,
//            onTextLayout = { textLayoutResultState.value = it },
//        )
//        if (!expanded) {
//            val density = LocalDensity.current
//            Text(
//                "... more",
//                onTextLayout = { seeMoreSizeState.value = it.size },
//                modifier = Modifier
//                    .then(
//                        if (seeMoreOffset != null)
//                            Modifier.offset(
//                                x = with(density) { seeMoreOffset.x.toDp() },
//                                y = with(density) { seeMoreOffset.y.toDp() },
//                            )
//                        else
//                            Modifier
//                    )
//                    .clickable {
//                        expanded = true
//                        cutText = null
//                    }
//                    .alpha(if (seeMoreOffset != null) 1f else 0f)
//            )
//        }
//    }
//}




@Preview(backgroundColor = 0xFFFFFFF)
@Composable
fun postTest(){

}