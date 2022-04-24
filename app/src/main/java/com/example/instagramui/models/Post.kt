package com.example.instagramui.models

import androidx.compose.ui.graphics.painter.Painter

data class Post(
    val id : Int,
    val image: String,
    val user: User,
    val likesCount: Int,
    val isLiked: Boolean = false,
    val caption: String,
    val commentsCount: Int,
    val timeStamp: Int
)


val names = arrayOf(
    "Zion",
    "Kai",
    "Maeve",
    "Nova",
    "Luca",
    "Aaliyah",
    "Quinn",
    "Eliana",
    "Jayden",
    "Isabella"
)

val caption = arrayOf(
    "Some days start better than others",
    "Today I will be as useless as the ‘g’ in lasagna",
    "Throw sass around like confetti.",
    "Hella heart eyes for you.",
    "Decluttering my life like Marie Kondo.",
    "Life is simple. It’s just not easy.",
    "You can’t live a full life on an empty stomach.",
    "Get out there and live a little.",
    "I’m not high maintenance, you’re just low effort.",
    "Whatever is good for your soul, do that.",
    "The way you speak to yourself matters the most.",
    "You can regret a lot of things but you’ll never regret being kind",
    "Being happy never goes out of style.",
    "A little contour and confidence.",
)