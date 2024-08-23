package com.example.kursovaya

import android.content.Context
import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import kotlinx.coroutines.delay

//@Composable
//fun jmpscr(){
//    val imageLoader = ImageLoader.Builder(context = LocalContext.current)
//        .components {
//            if (SDK_INT >= 28) {
//                add(ImageDecoderDecoder.Factory())
//            } else {
//                add(GifDecoder.Factory())
//            }
//        }
//        .build()
//    Image(
//        painter = rememberAsyncImagePainter(R.drawable.jumpscare, imageLoader),
//        contentDescription = null,
//        modifier = Modifier.fillMaxSize()
//    )
//}
@Composable
fun jmpscr(navController: NavController,context: Context) {
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    var currentImage by remember { mutableStateOf(0) }
    LaunchedEffect(currentImage) {
        if (currentImage == 0) {
            delay(2000) // время проигрывания гифки в миллисекундах
            currentImage += 1
        } else {
            navController.navigate(Marshroutes.route1) {
                popUpTo(Marshroutes.route1) { inclusive = true }
            }
        }
    }

    if (currentImage == 0) {
        playSound(context,R.raw.screamer)
        Image(
            painter = rememberAsyncImagePainter(R.drawable.jumpscare, imageLoader),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}