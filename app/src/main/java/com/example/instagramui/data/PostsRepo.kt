package com.example.instagramui.data

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import com.example.instagramui.models.Post
import com.example.instagramui.models.User
import com.example.instagramui.models.caption
import com.example.instagramui.models.names
import kotlin.random.Random

object PostsRepo {

    private val _posts = mutableStateOf<List<Post>>(emptyList())
    val posts: State<List<Post>> = _posts

    private fun populatePosts() {
        val posts = ArrayList<Post>()
        (0..9).forEach { index ->
            val post = Post(
                id = index + 1,
                image = "https://source.unsplash.com/random/400x300?$index",
                user = User(
                    name = names[index],
                    username = names[index],
                    image = "https://randomuser.me/api/portraits/men/${index + 1}.jpg"
                ),
                likesCount = Random.nextInt(100,400) ,
                caption = caption[index],
                commentsCount = Random.nextInt(10,50),
                timeStamp = Random.nextInt(1,12)
            )
            posts.add(post)
        }

        this._posts.value = posts
    }

    init {
        populatePosts()
    }
}