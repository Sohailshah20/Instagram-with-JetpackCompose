package com.example.instagramui.uicomponents

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.instagramui.models.ImageWithText
import com.example.instagramui.ui.theme.textColor

@Composable
fun PostTabView(
    modifier: Modifier = Modifier,
    imageWithText: List<ImageWithText>,
    onTabsSelected: (selectedIndex: Int) -> Unit
){
    var selectedTabIndex by remember {
        mutableStateOf(0)
    }
    TabRow(
        selectedTabIndex = selectedTabIndex,
        backgroundColor = MaterialTheme.colors.background,
        contentColor =  MaterialTheme.colors.textColor,
        modifier = modifier
    ) {
        imageWithText.forEachIndexed{ index, item ->
            Tab(
                selected = selectedTabIndex == index,
                selectedContentColor = MaterialTheme.colors.textColor,
                unselectedContentColor = MaterialTheme.colors.textColor.copy(0.4f),
                onClick = {
                    selectedTabIndex = index
                    onTabsSelected(index)
                }
            ) {
                Icon(
                    painter = item.image,
                    contentDescription = item.text,
                    tint = MaterialTheme.colors.textColor,
                    modifier = Modifier
                        .padding(10.dp)
                        .size(24.dp)

                )
            }
        }

    }
}