package com.example.instagramui.data

import androidx.compose.ui.graphics.painter.Painter

data class Post(
    val image: Painter,
    val userName: String,
    val likesCount: Int,
    val caption: String
)
