package com.example.kursovaya

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun Camera(x: MutableState<Int>, y: Int) {
    if (x.value == 1) {
        Scene(x,y)
    } else if(x.value==2) {
        Right1(x,y)
    }
    else{
        Left1(x,y)
    }
}