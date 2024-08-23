package com.example.kursovaya

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable
fun Office(context: Context) {
    var leftClosed by remember {
        mutableStateOf(LeftClosed)
    }
    var rightClosed by remember {
        mutableStateOf(RightClosed)
    }
    var leftLight by remember {
        mutableStateOf(LeftLight*1.0f)
    }
    var rightLight by remember {
        mutableStateOf(RightLight*1.0f)
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
    )
    {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.ofice),
            contentScale = ContentScale.Crop,
            contentDescription = "Офис",
            modifier = Modifier
                .fillMaxSize()
                .offset(-1.dp, 0.dp)
        )
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(126.dp)
                .offset(95.dp, 65.dp)
                .alpha(leftClosed * 1.0f)
        )
        {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.door),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Левая дверь",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(126.dp)
                .offset(95.dp, 65.dp)
                .alpha(leftLight)
        )
        {
            if(leftClosed==0){
                if (Position == 3) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.koridor1),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Левая дверь",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                else{
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.koridor),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Левая дверь",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .offset(40.dp, 115.dp)
                .background(color = Color.White)
                .clickable {
                    if (leftLight == 1.0f) {
                        leftLight = 0f
                        LeftLight = 0
                        tacking_b -= 1
                    } else {
                        if(Position==3){
                            playSound(context, R.raw.anim)
                        }
                        leftLight = 1.0f
                        tacking_b += 1
                        LeftLight = 1
                    }
                }
        )
        Box(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .offset(40.dp, 162.dp)
                .background(color = Color.Red)
                .clickable {
                    if (LeftClosed == 1) {
                        playSound(context, R.raw.door)
                        LeftClosed = 0
                        leftClosed = 0
                        tacking_b -= 1
                    } else {
                        playSound(context, R.raw.door)
                        LeftClosed = 1
                        leftClosed = 1
                        tacking_b += 1
                    }
                }
        )
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(126.dp)
                .offset(543.dp, 64.dp)
                .alpha(rightClosed * 1.0f)
        )
        {
            Image(
                bitmap = ImageBitmap.imageResource(R.drawable.door),
                contentScale = ContentScale.FillBounds,
                contentDescription = "Правая дверь",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Box(
            modifier = Modifier
                .height(200.dp)
                .width(126.dp)
                .offset(543.dp, 64.dp)
                .alpha(rightLight)
        )
        {
            if (rightClosed==0) {
                if (Position == 4) {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.koridor1),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Правая дверь",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                } else {
                    Image(
                        bitmap = ImageBitmap.imageResource(R.drawable.koridor),
                        contentScale = ContentScale.FillBounds,
                        contentDescription = "Правая дверь",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
        Box(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .offset(693.dp, 115.dp)
                .background(color = Color.White)
                .clickable {
                    if (rightLight == 1.0f) {
                        rightLight = 0f
                        RightLight = 0
                        tacking_b -= 1
                    } else {
                        if(Position==4){
                            playSound(context, R.raw.anim)
                        }
                        rightLight = 1.0f
                        tacking_b += 1
                        RightLight = 1
                    }
                }
        )
        Box(
            modifier = Modifier
                .height(32.dp)
                .width(32.dp)
                .offset(693.dp, 159.dp)
                .background(color = Color.Red)
                .clickable {
                    if (RightClosed == 1) {
                        playSound(context, R.raw.door)
                        RightClosed = 0
                        rightClosed = 0
                        tacking_b -= 1
                    } else {
                        playSound(context, R.raw.door)
                        RightClosed = 1
                        rightClosed = 1
                        tacking_b += 1
                    }
                }
        )
    }
}