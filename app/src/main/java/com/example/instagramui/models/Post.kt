package com.example.instagramui.models

import androidx.compose.ui.graphics.painter.Painter

data class Post(
    val id : Int,
    val image: String,
    val user: User,
    val likesCount: Int,
    val isLiked: Boolean = false
)


val names = arrayOf(
    "X Æ A-Xii",
    "Sigríðurjóna",
    "Vanithas",
    "Nathalia",
    "dark_emarlds",
    "Bianca",
    "Portabella",
    "Peridot",
    "Mordax",
    "Whistler"
)