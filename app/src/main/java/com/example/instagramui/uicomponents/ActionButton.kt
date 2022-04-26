package com.example.instagramui.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.instagramui.ui.theme.backgroundColor
import com.example.instagramui.ui.theme.lightGrey
import com.example.instagramui.ui.theme.textColor

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    icon : ImageVector? = null
){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .border(
                width = 0.5.dp,
                color = MaterialTheme.colors.lightGrey.copy(alpha = 0.4f),
                shape = RoundedCornerShape(5.dp)
            )
//            .padding(6.dp)
    ) {
        if (text != null){
            Text(
                text = text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                color  = MaterialTheme.colors.textColor
            )
            if( icon != null){
                Icon(imageVector = icon,
                    contentDescription = null,
                    tint =  MaterialTheme.colors.textColor
                )
            }
        }
    }
}