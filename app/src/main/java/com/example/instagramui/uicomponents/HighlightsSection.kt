package com.example.instagramui.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.instagramui.models.ImageWithText
import com.example.instagramui.models.Post
import com.example.instagramui.ui.theme.backgroundColor
import com.example.instagramui.ui.theme.textColor

@Composable
fun HighlightsSection(
    modifier: Modifier = Modifier,
    image: Painter,
    text: String
){
//    LazyRow(
//        modifier = modifier
//    ){
//        items(highlights.size){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(start = 10.dp,end = 10.dp)
            ) {
                RoundImage(
                    image = image,
                    modifier = Modifier.size(70.dp)
                )
                Text(
                    text = text,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center,
                    color  = MaterialTheme.colors.textColor,
                    fontSize = 12.sp,
                )
            }
        }
//    }
//}