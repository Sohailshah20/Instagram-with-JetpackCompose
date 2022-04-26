package com.example.instagramui.uicomponents

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.instagramui.models.Post

@ExperimentalFoundationApi
@Composable
fun PostsSection(
    image: Painter,
    modifier: Modifier = Modifier
){
//    LazyVerticalGrid(
//        cells = GridCells.Fixed(3),
//        modifier = modifier
//            .scale(1.01f)
//    ){
//        items(posts.size){
            Image(painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .border(
                        width = 1.dp,
                        color = MaterialTheme.colors.background
                    )
            )
        }
//    }
//}