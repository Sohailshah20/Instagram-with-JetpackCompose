package com.example.instagramui.models

import androidx.compose.ui.graphics.painter.Painter

data class User(
    val name: String,
    val username: String,
    val image: String,
)

val currentUser = User(
    name = "Sohail Shah",
    username = "Sohail__Shah_",
    image = "https://2.gravatar.com/avatar/25422d8001b67da26f4dbf08db91ad28?s=400&d=mm"
)
