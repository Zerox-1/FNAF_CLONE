package com.example.kursovaya

import android.content.Context
import android.media.MediaPlayer

fun playSound(context: Context,resourceId: Int) {
    val mediaPlayer = MediaPlayer.create(context, resourceId)
    mediaPlayer.start()
}