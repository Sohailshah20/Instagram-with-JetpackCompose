package com.example.instagramui.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopSearchBar(
    modifier : Modifier = Modifier,
    onClicked: () -> Unit
) {
    val backgroundColor = Color(0xFFEFEFEF)
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(35.dp)
            .padding(horizontal = 12.dp)
//            .offset(y = 12.dp)
        ,
    ) {
        Surface(
            modifier = Modifier
                .clickable(onClick = onClicked)
            ,
            shape = RoundedCornerShape(8.dp),
            elevation = AppBarDefaults.TopAppBarElevation
        ) {
            TopAppBar(
                title = {
                    Text(
                        modifier = Modifier
                            .alpha(ContentAlpha.medium),
                        text = "Search Here",

                        )
                },
                backgroundColor = backgroundColor,
                navigationIcon = {
                    IconButton(onClick = onClicked) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Icon"
                        )
                    }
                }

            )
        }
    }
}

@Preview
@Composable
fun test(){
    TopSearchBar(onClicked = {})
}