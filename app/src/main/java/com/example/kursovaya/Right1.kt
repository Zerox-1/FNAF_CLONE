package com.example.kursovaya

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable
fun Right1(x: MutableState<Int>, y: Int) {
    if(y==2) {
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.right2),
            contentScale = ContentScale.Crop,
            contentDescription = "Правый коридор",
            modifier = Modifier
                .fillMaxSize()
                .offset(-1.dp, 0.dp)
        )
    }
    else{
        Image(
            bitmap = ImageBitmap.imageResource(R.drawable.right),
            contentScale = ContentScale.Crop,
            contentDescription = "Правый коридор",
            modifier = Modifier
                .fillMaxSize()
                .offset(-1.dp, 0.dp)
        )
    }
    Box(modifier = Modifier.offset(LocalConfiguration.current.screenWidthDp.dp/2+50.dp, LocalConfiguration.current.screenHeightDp.dp-80.dp)) {
        Row {
            Button(onClick = { x.value = 3 }) { Text(text = "Левая дверь") }
            Button(onClick = { x.value = 1 }) { Text(text = "Сцена") }
            Button(onClick = { x.value = 2 }) { Text(text = "Правая дверь") }
        }
    }
}